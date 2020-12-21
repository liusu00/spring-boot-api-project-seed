package com.conpany.project.followUpVisit;

import com.company.project.model.*;
import com.company.project.service.*;
import com.conpany.project.Tester;
import com.conpany.project.util.POIUtil;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FollowExcelImport extends Tester {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitPlanService visitPlanService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private UserService userService;

    @Autowired
    private DictService dictService;
    @Autowired
    private RegistrationService registrationService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/M/d");


    @Test
    @Rollback(false)
    public void imports() {
        String filePath = "C:\\Users\\liusu\\Desktop\\提交资料\\随访\\随访记录表-2020-12-06 23_06_00.xlsx";


        List<User> users = userService.findAll();
        Map<String, String> userMap = users.stream().collect(Collectors.toMap(User::getName, User::getId,(v1,v2)->v1));

        Condition condition = new Condition(Dict.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("dictTypeId", "e37c2d07018b465ca6714abf574a5f3e");
        List<Dict> byCondition = dictService.findByCondition(condition);
        Map<String, String> dictMap = byCondition.stream().collect(Collectors.toMap(Dict::getLabel, Dict::getValue));

        Condition condition3 = new Condition(Dict.class);
        Example.Criteria criteria3 = condition3.createCriteria();
        criteria3.andEqualTo("dictTypeId", "94d965d658294f389ea6166d2c45659b");
        List<Dict> byCondition3 = dictService.findByCondition(condition3);
        Map<String, String> dictMap3 = byCondition3.stream().collect(Collectors.toMap(Dict::getLabel, Dict::getValue));


        Condition condition5 = new Condition(Dict.class);
        Example.Criteria criteria5 = condition5.createCriteria();
        criteria5.andEqualTo("dictTypeId", "caed046de8aa4917a6e674213116eaf3");
        List<Dict> byCondition5 = dictService.findByCondition(condition5);
        Map<String, String> dictMap5 = byCondition5.stream().collect(Collectors.toMap(Dict::getLabel, Dict::getValue));


        InputStream fis = null;
        ArrayList<Visit> list = new ArrayList();
        ArrayList<VisitPlan> visitPlans = new ArrayList();
        Set<String> cardNumList = new HashSet();
        try {
            fis = new FileInputStream(filePath);
            Workbook workbook = null;
            if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (filePath.endsWith(".xls") || filePath.endsWith(".et")) {
                workbook = new HSSFWorkbook(fis);
            }
            fis.close();
            // 获取第一个sheet表，也可使用sheet表名获取
            Sheet sheet = workbook.getSheetAt(0);
            // 获取行
            Iterator<Row> rows = sheet.rowIterator();
            Row row;
            int i = 0;
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){
                    //病历号
                    String cellValue = POIUtil.getCellValue(row.getCell(2));
                    if(cellValue == null){
                        continue;
                    }
                    cardNumList.add(cellValue);
                    Visit info = new Visit();
                    VisitPlan visitPlan = new VisitPlan();
                    visitPlan.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    visitPlan.setFlag("1");
                    visitPlan.setDelFlag("0");

                    info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    info.setDelFlag("0");
                    info.setVisitModel("1");
                    info.setVisitTimeModel("1");

                    visitPlan.setVisitId(info.getId());
                    info.setNo(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(0));
                    info.setName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(3));
                    visitPlan.setVisitStaff(userMap.get(cellValue));
                    visitPlan.setVisitStaffType("2");

                    cellValue = POIUtil.getCellValue(row.getCell(4));
                    if(!"".equals(cellValue))
                        visitPlan.setPlanVisitTime(sdf.parse(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(6));
                    visitPlan.setDoctorId(userMap.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(7));
                    visitPlan.setVisitStaff(userMap.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(8));
                    visitPlan.setContent(cellValue);

                    Cell cell = row.getCell(9);
                    if(cell != null){
                        if(row.getCell(9).toString().length() > 255){
                            visitPlan.setResultInfo(row.getCell(9).toString().substring(0,255));

                        }else{
                            visitPlan.setResultInfo(row.getCell(9).toString());

                        }
                    }

                    cellValue = POIUtil.getCellValue(row.getCell(10));
                    visitPlan.setVisitBy(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(11));
                    if(!"".equals(cellValue)){
                        visitPlan.setVisitTime(sdf.parse(cellValue));

                    }

                    cellValue = POIUtil.getCellValue(row.getCell(13));//就诊时间
                    info.setTime(cellValue.split(" ")[0]);

                    cellValue = POIUtil.getCellValue(row.getCell(14));//随访模板

                    cellValue = POIUtil.getCellValue(row.getCell(15));//随访项目
                    visitPlan.setProjectId(dictMap.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(16));
                    info.setCreateBy(userMap.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(17));
                    if(!"".equals(cellValue) && cellValue.startsWith("20"))
                        info.setCreateDate(sdf.parse(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(18));
                    visitPlan.setCommunicationMethod(dictMap3.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(20));
                    visitPlan.setStatus(dictMap5.get(cellValue));

                    list.add(info);
                    visitPlans.add(visitPlan);
                }
                i++;
            }
            System.out.println("开始...");

            List<Patient> patients = new ArrayList<>();
            List<Registration> regs = new ArrayList<>();

            List<List<String>> cardNumListPartition = Lists.partition(new ArrayList<>(cardNumList), 20000);
            cardNumListPartition.forEach(data -> {
                Condition condition2 = new Condition(Patient.class);
                Example.Criteria criteria2 = condition2.createCriteria();
                criteria2.andIn("cardNumber", data);
                criteria2.andIsNotNull("cardNumber");
                patients.addAll(patientService.findByCondition(condition2));
            });
            System.out.println("读取患者完毕...");


            cardNumListPartition.forEach(data -> {
                Condition condition4 = new Condition(Registration.class);
                Example.Criteria criteria4 = condition4.createCriteria();
                criteria4.andIn("anamnesisNo", data);
                regs.addAll(registrationService.findByCondition(condition4));
            });

            System.out.println("读取预约完毕...");

            Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(v->v.getName() + v.getCardNumber(), Patient::getId,(v1,v2)->v1));
            Map<String, String> patientClintMap = patients.stream().collect(Collectors.toMap(v->v.getName() + v.getCardNumber(), Patient::getClinicId,(v1,v2)->v1));
            Map<String, String> regsMap = regs.stream().collect(Collectors.toMap(t -> t.getPatientId() + sdf2.format(t.getAppointmentTime()), Registration::getId,(v1,v2)->v1));

            for (Visit visit : list) {
                visit.setPatientId(patientMap.get(visit.getName()+visit.getNo()));
                visit.setClinicId(patientClintMap.get(visit.getName()+visit.getNo()));
                if(!"".equals(visit.getTime())){
                    visit.setRegistrationId(regsMap.get(visit.getPatientId()+visit.getTime()));
                }
            }

            List<List<Visit>> partition = Lists.partition(list, 5000);
            partition.forEach(data -> {
                visitService.saveUid(data);
            });

            List<List<VisitPlan>> visitPlansPartition = Lists.partition(visitPlans, 5000);
            visitPlansPartition.forEach(data -> {
                visitPlanService.saveUid(data);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
