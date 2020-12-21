package com.conpany.project.other;

import com.company.project.model.*;
import com.company.project.service.*;
import com.conpany.project.Tester;
import com.conpany.project.util.POIUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class RegistrationExcelImport extends Tester {

    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscribeTypeConfigService subscribeTypeConfigService;
    @Autowired
    private RegistrationProjectRelService registrationProjectRelService;
    @Autowired
    private RegistrationService registrationService;

    //String clinicId = "0cdc709140b545958002ce2fe64de3f1";//优享国际口腔八方门诊部
    //String clinicId = "43b2685eddd448bd8f5a42b62f6a0b80";//优享国际口腔保利门诊部
    //String clinicId = "d7456aa21f354181a389dd321531d4ed";//优享国际口腔春天百货门诊部
    //String clinicId = "f1a28d87bca04554b47bc83bc2b31034";//优享国际口腔邵阳旗舰店
    //String clinicId = "4e2c7c1ce25f4ac58d2e24c866d28156";//优享国际口腔万家丽门诊部
    //String clinicId = "d108e55dfdaa4358ad1789808ee5a5ef";//优享国际口腔吾悦门诊部
    //String clinicId = "7ac3986edb7847728c1443773e138051";//优享国际口腔喜盈门门诊部
    //String clinicId = "299ee6061eba44acb802da1b3141ad01";//优享国际口腔新世界旗舰店
    //String clinicId = "a35b4438b7414212933035f8f8a8a190";//优享国际口腔新天地门诊部



    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    @Rollback(false)
    public void importAll() {

        String filepath = "C:\\Users\\liusu\\Desktop\\提交资料\\邵阳";
        try {

            File file = new File(filepath);
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath + "\\" + filelist[i]);
                if (!readfile.isDirectory()) {
                    System.out.println("path=" + readfile.getPath());
                    imports(readfile.getPath());
                }
            }
        } catch (Exception e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
    }

    public void imports(String filePath) {
        String clinicId = "";
        if(filePath.contains("八方店")){
            clinicId = "0cdc709140b545958002ce2fe64de3f1";
        }else if(filePath.contains("保利店")){
            clinicId = "43b2685eddd448bd8f5a42b62f6a0b80";
        }else if(filePath.contains("春天百货店")){
            clinicId = "d7456aa21f354181a389dd321531d4ed";
        }else if(filePath.contains("邵阳旗舰店")){
            clinicId = "f1a28d87bca04554b47bc83bc2b31034";
        }else if(filePath.contains("万家丽店")){
            clinicId = "4e2c7c1ce25f4ac58d2e24c866d28156";
        }else if(filePath.contains("吾悦广场店")){
            clinicId = "d108e55dfdaa4358ad1789808ee5a5ef";
        }else if(filePath.contains("喜盈门店")){
            clinicId = "7ac3986edb7847728c1443773e138051";
        }else if(filePath.contains("新世界旗舰店")){
            clinicId = "299ee6061eba44acb802da1b3141ad01";
        }else if(filePath.contains("新天地店")){
            clinicId = "a35b4438b7414212933035f8f8a8a190";
        }
        List<User> users = userService.findAll();
        Map<String, String> userMap = users.stream().collect(Collectors.toMap(User::getName, User::getId,(v1,v2)->v1));

        Condition subCondition = new Condition(SubscribeTypeConfig.class);
        Example.Criteria subCriteria = subCondition.createCriteria();
        subCriteria.andIsNotNull("parentId");
        List<SubscribeTypeConfig> configs = subscribeTypeConfigService.findByCondition(subCondition);
        Map<String, String> configMap = configs.stream().collect(Collectors.toMap(SubscribeTypeConfig::getName, SubscribeTypeConfig::getId));

        System.out.println("读取用户");
        InputStream fis = null;

        ArrayList<Registration> list = new ArrayList();
        ArrayList<RegistrationProjectRel> rels = new ArrayList();
        ArrayList<String> cardNumList = new ArrayList();

        try {
            fis = new FileInputStream(filePath);
            Workbook workbook = null;
            if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (filePath.endsWith(".xls") || filePath.endsWith(".et")) {
                workbook = new HSSFWorkbook(fis);
            }
            fis.close();
            /* 读EXCEL文字内容 */
            // 获取第一个sheet表，也可使用sheet表名获取
            Sheet sheet = workbook.getSheetAt(0);
            // 获取行
            Iterator<Row> rows = sheet.rowIterator();
            Row row;
            int i = 0;
            //
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){
                    /**
                     * 预约表symptomatic_type,subscribe_type这两个字段如何判断?
                     * type_status默认为1?
                     * remind_number,is_reception,is_check,is_transfer_treatment,is_end_therapy,is_triage全部默认为0?
                     *
                     *  symptomatic_type 按照最远的时间插入，第一次为初诊，如果相同用户有第二次预约即复诊。
                     * subscribe_type全部为1就好了
                     *
                     * 2020-01-01 15:30:00
                     *
                     * 姓名	病历号	手机	预约时间	预约医生	预约项目	预约状态	创建时间	创建人	创建人岗位	网电咨询师	备注	科室	就诊类型	咨询师	类型
                     */
                    String cellValue = "";

                    RegistrationProjectRel rel = new RegistrationProjectRel();
                    rel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    Registration info = new Registration();
                    info.setDelFlag("0");
                    info.setClinicId(clinicId);
                    info.setId(UUID.randomUUID().toString().replaceAll("-", ""));

                    info.setSubscribeType("1");

                    info.setRemindNumber(0);
                    info.setIsReception(false);
                    info.setIsCheck(false);
                    info.setIsTransferTreatment(false);
                    info.setIsEndTherapy(false);
                    info.setIsTriage(false);

                    cellValue = POIUtil.getCellValue(row.getCell(0));//姓名
                    info.setName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(1));//病历号
                    info.setAnamnesisNo(cellValue);
                    cardNumList.add(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(3));//预约时间
                    if("".equals(cellValue)){
                        System.err.println("第"+ i +"行错误");
                        throw new Exception();
                    }
                    info.setAppointmentPeriodBegin(sdf2.parse(cellValue));
                    info.setAppointmentPeriodEnd(new Date(info.getAppointmentPeriodBegin().getTime() + 30*60*1000));
                    info.setAppointmentTime(sdf2.parse(cellValue));
                    info.setEventTime(sdf2.parse(cellValue));


                    cellValue = POIUtil.getCellValue(row.getCell(4));//预约医生
                    info.setDoctorId(userMap.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(5));//预约项目
                    rel.setProjectId(configMap.get(cellValue));
                    rel.setRegistrationId(info.getId());

                    cellValue = POIUtil.getCellValue(row.getCell(6));//预约状态
                    //1、预约  2、已确定  3、已到店 4已挂号 5、治疗中 6、治疗完成 7、已结账 8、已离开 9、已失约
                    if("未确认".equals(cellValue)){
                        info.setAppointmentStatus("1");
                    }else if("治疗完成".equals(cellValue)){
                        info.setAppointmentStatus("6");
                    }else if("已结账".equals(cellValue)){
                        info.setAppointmentStatus("7");
                    }else if("已取消".equals(cellValue)){
                        info.setAppointmentStatus("11");
                    }else if("失约".equals(cellValue)){
                        info.setAppointmentStatus("9");
                    }else if("已挂号".equals(cellValue)){
                        info.setAppointmentStatus("4");
                    }else if("治疗中".equals(cellValue)){
                        info.setAppointmentStatus("5");
                    }else if("已离开".equals(cellValue)){
                        info.setAppointmentStatus("8");
                    }else if("已确认".equals(cellValue)){
                        info.setAppointmentStatus("2");
                    }
                    //未确认、已取消、失约、待定
                    //不插挂号时间
                    if("未确认".equals(cellValue) || "已取消".equals(cellValue) || "失约".equals(cellValue) || "待定".equals(cellValue)){
                        info.setEventTime(null);
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(7));//创建时间
                    info.setCreateDate(sdf2.parse(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(8));//创建人
                    if(!"".equals(cellValue)){
                        info.setCreateBy(userMap.get(cellValue));
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(9));//创建人岗位


                    cellValue = POIUtil.getCellValue(row.getCell(10));//网电咨询师
                    if(!"".equals(cellValue)){
                        info.setNetworkElectricalCounselorId(userMap.get(cellValue));
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(11));//备注
                    if(cellValue.length()>200){
                        info.setRemarks(cellValue.substring(0, 200));
                    }else{
                        info.setRemarks(cellValue);
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(13));//就诊类型
                    //1、初诊 2、复诊初治
                    // 3 复诊 4、复查 5、复诊再治疗
                    if("初诊".equals(cellValue)){
                        info.setSymptomaticType("1");
                    }else if("复诊初治".equals(cellValue)){
                        info.setSymptomaticType("2");
                    }else if("复诊".equals(cellValue)){
                        info.setSymptomaticType("3");
                    }else if("复查".equals(cellValue)){
                        info.setSymptomaticType("4");
                    }else if("复诊再治疗".equals(cellValue)){
                        info.setSymptomaticType("5");
                    }else{
                        info.setSymptomaticType("3");
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(14));//咨询师
                    if(!"".equals(cellValue)){
                        info.setCounselor(userMap.get(cellValue));
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(15));
                    if("预约".equals(cellValue)){
                        info.setTypeStatus("1");
                    }else if("到店".equals(cellValue)){
                        info.setTypeStatus("2");
                    }

                    list.add(info);
                    rels.add(rel);

                }
                i++;
            }
            Condition condition = new Condition(Patient.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andIn("cardNumber", cardNumList);
            //criteria.andEqualTo("clinicId",clinicId);
            List<Patient> patients = patientService.findByCondition(condition);
            Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(v->v.getCardNumber() + v.getName(), Patient::getId,(v1,v2)->v1));
            Iterator<Registration> iterator = list.iterator();
            while (iterator.hasNext()) {
                Registration data = iterator.next();
                data.setPatientId(patientMap.get(data.getAnamnesisNo()+data.getName()));
                if(StringUtils.isBlank(data.getPatientId())){
                    iterator.remove();
                }
            }
       /* list.forEach(data -> {
            data.setPatientId(patientMap.get(data.getAnamnesisNo()+data.getName()));
            if(StringUtils.isBlank(data.getPatientId())){

            }
        });*/
            System.out.println("读取患者");
            List<List<Registration>> partition = Lists.partition(list, 5000);
            partition.forEach(data -> {
                registrationService.saveUid(data);
            });

            List<List<RegistrationProjectRel>> relLists = Lists.partition(rels, 5000);
            relLists.forEach(data -> {
                registrationProjectRelService.saveUid(data);
            });

            System.out.println("读取完毕:"+filePath);
            System.out.println("插入行数:"+i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {//FileNotFoundException
            e.printStackTrace();
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }

    }
}
