package com.conpany.project.other;

import com.company.project.model.MedicalRecord;
import com.company.project.model.Patient;
import com.company.project.model.User;
import com.company.project.service.MedicalRecordService;
import com.company.project.service.PatientService;
import com.company.project.service.PatientSourceService;
import com.company.project.service.UserService;
import com.conpany.project.Tester;
import com.conpany.project.util.POIUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelImport extends Tester {

    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientSourceService patientSourceService;

    @Test
    @Rollback(false)
    public void imports() {
        List<User> users = userService.findAll();
        Map<String, String> userMap = users.stream().collect(Collectors.toMap(User::getName, User::getId,(v1,v2)->v1));

        List<Map> patientSources = patientSourceService.findIdAndName();
        HashMap patientSourceMap = new HashMap();
        for (Map map : patientSources) {
            patientSourceMap.put(map.get("name"), map.get("id"));
        }

        String filePath = "C:\\Users\\liusu\\Desktop\\提交资料\\新世界\\患者.xlsx";
        InputStream fis = null;
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
            Cell cell;
            int i = 0;
            ArrayList list = new ArrayList();
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){
                    //病历号	姓名	昵称	性别	生日	手机号	电话	邮箱	QQ	微信	身份证
                    // 国籍	地址	患者一级来源	患者二级来源	患者三级来源	备注	患者标签	初诊时间
                    // 初诊医生	责任医生	咨询师	网电咨询师	消费总额	患者欠费
                    // 其他病历号	创建时间	创建人
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");

                    Patient info = new Patient();
                    info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    info.setDelFlag("0");
                    info.setClinicId("299ee6061eba44acb802da1b3141ad01");

                    String cellValue = POIUtil.getCellValue(row.getCell(0));
                    info.setCardNumber(cellValue);
                    if(cellValue.startsWith("L")){
                        info.setPatientType("2");
                    }else{
                        info.setPatientType("1");
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(1));
                    info.setName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(2));
                    info.setNickName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(3));
                    if("男".equals(cellValue)){
                        info.setSex("1");
                    }else if("女".equals(cellValue)){
                        info.setSex("2");
                    }else{
                        info.setSex("0");
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(4));
                    if(cellValue != "")
                    info.setBirthday(sdf.parse(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(5));
                    info.setTelephoneNo(cellValue.split(" ；")[0]
                            .replace("本人：","")
                            .replace("其他：","")
                            .replace("母亲：","")
                            .replace("妈妈：","")
                            .replace("儿子：","")
                            .replace("父亲：","")
                            .replace("同行朋友：","")
                            .replace("本人第二个电话号码：","")
                    );

                    cellValue = POIUtil.getCellValue(row.getCell(6));
                    info.setTelNo(cellValue.replace("家：","").replace("：",""));

                    cellValue = POIUtil.getCellValue(row.getCell(7));
                    info.setEmail(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(8));
                    info.setQqNo(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(9));
                    info.setWechatNo(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(10));
                    info.setCardNo(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(11));
                    info.setNationName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(12));
                    info.setDetailAddress(cellValue);
                    //患者一级来源
                    String first = POIUtil.getCellValue(row.getCell(13));
                    String second = POIUtil.getCellValue(row.getCell(14));
                    String third = POIUtil.getCellValue(row.getCell(15));
                    String key = "";
                    if("".equals(third)){
                        String[] str = {first, second };
                        key = StringUtils.join(str,"-");
                    }else{
                        String[] str = {first, second, third};
                        key = StringUtils.join(str,"-");
                    }
                    String val = (String)patientSourceMap.get(key);
                    if(val != null){
                        String[] split = val.split("-");
                        info.setOneLevelSource(split[0]);
                        info.setTwoLevelSource(split[1]);
                        if(split.length==3)
                            info.setThreeLevelSource(split[2]);
                    }


                    cellValue = POIUtil.getCellValue(row.getCell(16));
                    info.setRemarks(cellValue);

                    /**
                     * 标签
                     */
                    cellValue = POIUtil.getCellValue(row.getCell(17));
                    info.setTag(cellValue);

                    /**
                     * 初诊时间
                     */
                    cellValue = POIUtil.getCellValue(row.getCell(18));
                    if(cellValue != "")
                    info.setBeginDate(sdf.parse(cellValue));

                    //初诊医生	责任医生	咨询师	网电咨询师
                    cellValue = POIUtil.getCellValue(row.getCell(19));
                    info.setFirstDoctorId(userMap.get(cellValue));



                    /**
                     * 创建时间
                     */
                    cellValue = POIUtil.getCellValue(row.getCell(26));
                    if(cellValue != "")
                    info.setCreateDate(sdf2.parse(cellValue));

                    list.add(info);
                }
                i++;

                System.out.println();
            }

            patientService.saveUid(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
