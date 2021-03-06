package com.conpany.project.other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MedicalRecordsExcelImport extends Tester {

    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private MedicalRecordErrorService medicalRecordErrorService;
    @Autowired
    private MedicalRecordYwService medicalRecordYwService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @Autowired
    private MedicalRecordTreatmentPlanService treatmentPlanService;
    @Autowired
    private MedicalRecordHandleService handleService;
    @Autowired
    private MedicalRecordDiagnosisService medicalRecordDiagnosisService;
    @Autowired
    private MedicalRecordSupportExamineService supportExamineService;
    @Autowired
    private MedicalRecordMonthExamineService monthExamineService;
    @Autowired
    private RegistrationService registrationService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    @Rollback(false)
    public void importAll() {
        String filepath = "F:\\新世界";
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
            e.printStackTrace();
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
    }

    public void imports(String filePath) {
        String clinicId = "";
        if(filePath.contains("八方")){
            clinicId = "0cdc709140b545958002ce2fe64de3f1";
        }else if(filePath.contains("保利")){
            clinicId = "43b2685eddd448bd8f5a42b62f6a0b80";
        }else if(filePath.contains("春天百货")){
            clinicId = "d7456aa21f354181a389dd321531d4ed";
        }else if(filePath.contains("邵阳")){
            clinicId = "f1a28d87bca04554b47bc83bc2b31034";
        }else if(filePath.contains("万家丽")){
            clinicId = "4e2c7c1ce25f4ac58d2e24c866d28156";
        }else if(filePath.contains("吾悦")){
            clinicId = "d108e55dfdaa4358ad1789808ee5a5ef";
        }else if(filePath.contains("喜盈门")){
            clinicId = "7ac3986edb7847728c1443773e138051";
        }else if(filePath.contains("新世界")){
            clinicId = "299ee6061eba44acb802da1b3141ad01";
        }else if(filePath.contains("新天地")){
            clinicId = "a35b4438b7414212933035f8f8a8a190";
        }

        List<User> users = userService.findAll();
        Map<String, String> userMap = users.stream().collect(Collectors.toMap(User::getName, User::getId,(v1,v2)->v1));
        System.out.println("读取用户");

        InputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            Workbook workbook = null;
            if (filePath.endsWith(".Xlsx")) {
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
            ArrayList<MedicalRecordError> errorlist = new ArrayList();
            ArrayList<MedicalRecordYw> ywList = new ArrayList();
            ArrayList<MedicalRecord> list = new ArrayList();
            ArrayList treatmentPlanList = new ArrayList();
            ArrayList handleList = new ArrayList();
            ArrayList medicalRecordDiagnosisList = new ArrayList();
            ArrayList supportExamineList = new ArrayList();
            ArrayList monthExamineList = new ArrayList();

            Set<String> cardNumList = new HashSet();
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){
                    String creatTiemStr = POIUtil.getCellValue(row.getCell(4));
                    Date parse = sdf2.parse(creatTiemStr);
                    if(parse.after(sdf2.parse("2020/12/07 00:00:00"))){
                        continue;
                    }

                    MedicalRecord info = new MedicalRecord();
                    info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    info.setDelFlag("0");
                    info.setClinicId(clinicId);
                    info.setCreateBy("1");
                    info.setMedicalRecordType("1");

                    /**
                     * 患者	病历号	预约医生	病例医生	病历创建时间	主诉	现病史	既往史
                     * 口腔检查	辅助检查	诊断	治疗计划	处置	医嘱	标签	备注
                     */

                    String cellValue = POIUtil.getCellValue(row.getCell(0));
                    info.setName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(1)).trim();
                    cardNumList.add(cellValue);
                    info.setNo(cellValue);
                    //预约医生

                    //病例医生
                    cellValue = POIUtil.getCellValue(row.getCell(3));
                    info.setDoctorId(userMap.get(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(4));
                    info.setCreateDate(sdf2.parse(cellValue));
                    //主诉
                    cellValue = POIUtil.getCellValue(row.getCell(5));
                    info.setChiefComplaint(cellValue);
                    //现病史
                    cellValue = POIUtil.getCellValue(row.getCell(6));
                    info.setHpIllness(cellValue);
                    //既往史
                    cellValue = POIUtil.getCellValue(row.getCell(7));
                    info.setPastHistory(cellValue);
                    //口腔检查
                    //MedicalRecordDiagnosis
                    //MedicalRecordHandle
                    //MedicalRecordMonthExamine
                    //MedicalRecordSupportExamine
                    //MedicalRecordTreatmentPlan
                    MedicalRecordYw yw = new MedicalRecordYw();
                    yw.setId(info.getId());
                    cellValue = POIUtil.getCellValue(row.getCell(8));
                    yw.setKqjc(cellValue);

                    if(!cellValue.equals("") && cellValue.length()>3){
                        String[] split = cellValue.substring(3).split(",牙位：");
                        for (String s : split) {
                            MedicalRecordMonthExamine examine = new MedicalRecordMonthExamine();
                            examine.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            examine.setCreateBy("1");
                            examine.setCreateDate(new Date());
                            examine.setDelFlag("0");
                            examine.setMedicalRecordId(info.getId());

                            String[] split1 = s.split(";内容：");
                            String replace = split1[0];
                            if(!"".equals(replace)){
                                String[] split2 = replace.split(",");
                                JSONArray array = new JSONArray();
                                for (String s1 : split2) {
                                    JSONObject json = new JSONObject();
                                    boolean matches = s1.substring(0, 1).matches("^[0-9]*$");
                                    if(matches){
                                        if(Integer.valueOf(s1.substring(0,1))<=2){
                                            json.put("position",Integer.valueOf(s1.substring(0,1))-1);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==3){
                                            json.put("position",3);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==4){
                                            json.put("position",2);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==5){
                                            json.put("position",0);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==6){
                                            json.put("position",1);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==7){
                                            json.put("position",3);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==8){
                                            json.put("position",2);
                                            setSerialNumber(json, s1);
                                        }
                                        array.add(json);
                                    }
                                }
                                examine.setToothPositions(array.toJSONString());
                            }

                            if(split1.length>1) examine.setResult(split1[1].length()>500?split1[1].substring(0, 500):split1[1]);
                            monthExamineList.add(examine);
                        }
                    }


                    //辅助检查
                    cellValue = POIUtil.getCellValue(row.getCell(9));
                    yw.setFzjc(cellValue);
                    if(!cellValue.equals("") && cellValue.length()>3){
                        String[] split = cellValue.substring(3).split(",牙位：");
                        for (String s : split) {
                            MedicalRecordSupportExamine examine = new MedicalRecordSupportExamine();
                            examine.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            examine.setCreateBy("1");
                            examine.setCreateDate(new Date());
                            examine.setDelFlag("0");
                            examine.setMedicalRecordId(info.getId());

                            String[] split1 = s.split(";内容：");
                            String replace = split1[0];
                            if(!"".equals(replace)){
                                String[] split2 = replace.split(",");
                                JSONArray array = new JSONArray();
                                for (String s1 : split2) {
                                    JSONObject json = new JSONObject();
                                    boolean matches = s1.substring(0, 1).matches("^[0-9]*$");
                                    if(matches){
                                        if(Integer.valueOf(s1.substring(0,1))<=2){
                                            json.put("position",Integer.valueOf(s1.substring(0,1))-1);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==3){
                                            json.put("position",3);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==4){
                                            json.put("position",2);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==5){
                                            json.put("position",0);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==6){
                                            json.put("position",1);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==7){
                                            json.put("position",3);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==8){
                                            json.put("position",2);
                                            setSerialNumber(json, s1);
                                        }
                                        array.add(json);
                                    }

                                }
                                examine.setToothPositions(array.toJSONString());
                            }
                            if(split1.length>1) examine.setResult(split1[1].length()>500?split1[1].substring(0, 500):split1[1]);
                            supportExamineList.add(examine);
                        }
                    }


                    //	诊断
                    cellValue = POIUtil.getCellValue(row.getCell(10));
                    yw.setZd(cellValue);
                    if(!cellValue.equals("") && cellValue.length()>3){
                        String[] split = cellValue.substring(3).split(",牙位：");
                        for (String s : split) {
                            MedicalRecordDiagnosis examine = new MedicalRecordDiagnosis();
                            examine.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            examine.setCreateBy("1");
                            examine.setCreateDate(new Date());
                            examine.setDelFlag("0");
                            examine.setMedicalRecordId(info.getId());

                            String[] split1 = s.split(";内容：");
                            String replace = split1[0];
                            if(!"".equals(replace)){
                                String[] split2 = replace.split(",");
                                JSONArray array = new JSONArray();
                                for (String s1 : split2) {
                                    JSONObject json = new JSONObject();
                                    boolean matches = s1.substring(0, 1).matches("^[0-9]*$");
                                    if(matches){
                                        if(Integer.valueOf(s1.substring(0,1))<=2){
                                            json.put("position",Integer.valueOf(s1.substring(0,1))-1);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==3){
                                            json.put("position",3);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==4){
                                            json.put("position",2);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==5){
                                            json.put("position",0);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==6){
                                            json.put("position",1);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==7){
                                            json.put("position",3);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==8){
                                            json.put("position",2);
                                            setSerialNumber(json, s1);
                                        }
                                        array.add(json);
                                    }

                                }
                                examine.setToothPositions(array.toJSONString());
                            }
                            if(split1.length>1) examine.setResult(split1[1].length()>500?split1[1].substring(0, 500):split1[1]);
                            medicalRecordDiagnosisList.add(examine);
                        }
                    }


                    //治疗计划
                    cellValue = POIUtil.getCellValue(row.getCell(11));
                    yw.setZljh(cellValue);
                    if(!cellValue.equals("") && cellValue.length()>3){
                        String[] split = cellValue.substring(3).split(",牙位：");
                        for (String s : split) {
                            MedicalRecordTreatmentPlan examine = new MedicalRecordTreatmentPlan();
                            examine.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            examine.setCreateBy("1");
                            examine.setCreateDate(new Date());
                            examine.setDelFlag("0");
                            examine.setMedicalRecordId(info.getId());

                            String[] split1 = s.split(";内容：");
                            String replace = split1[0];
                            if(!"".equals(replace)){
                                String[] split2 = replace.split(",");
                                JSONArray array = new JSONArray();
                                for (String s1 : split2) {
                                    JSONObject json = new JSONObject();
                                    boolean matches = s1.substring(0, 1).matches("^[0-9]*$");
                                    if(matches){
                                        if(Integer.valueOf(s1.substring(0,1))<=2){
                                            json.put("position",Integer.valueOf(s1.substring(0,1))-1);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==3){
                                            json.put("position",3);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==4){
                                            json.put("position",2);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==5){
                                            json.put("position",0);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==6){
                                            json.put("position",1);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==7){
                                            json.put("position",3);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==8){
                                            json.put("position",2);
                                            setSerialNumber(json, s1);
                                        }
                                        array.add(json);
                                    }

                                }
                                examine.setToothPositions(array.toJSONString());
                            }
                            if(split1.length>1) examine.setResult(split1[1].length()>500?split1[1].substring(0, 500):split1[1]);
                            treatmentPlanList.add(examine);
                        }
                    }


                    //处置
                    cellValue = POIUtil.getCellValue(row.getCell(12));
                    yw.setCz(cellValue);
                    ywList.add(yw);
                    if(!cellValue.equals("") && cellValue.length()>3){
                        String[] split = cellValue.substring(3).split(",牙位：");
                        for (String s : split) {
                            MedicalRecordHandle examine = new MedicalRecordHandle();
                            examine.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            examine.setCreateBy("1");
                            examine.setCreateDate(new Date());
                            examine.setDelFlag("0");
                            examine.setMedicalRecordId(info.getId());

                            String[] split1 = s.split(";内容：");
                            String replace = split1[0];
                            if(!"".equals(replace)){
                                String[] split2 = replace.split(",");
                                JSONArray array = new JSONArray();
                                for (String s1 : split2) {
                                    JSONObject json = new JSONObject();
                                    boolean matches = s1.substring(0, 1).matches("^[0-9]*$");
                                    if(matches){
                                        if(Integer.valueOf(s1.substring(0,1))<=2){
                                            json.put("position",Integer.valueOf(s1.substring(0,1))-1);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==3){
                                            json.put("position",3);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==4){
                                            json.put("position",2);
                                            json.put("serialNumber",s1.substring(1));
                                        }else if(Integer.valueOf(s1.substring(0,1))==5){
                                            json.put("position",0);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==6){
                                            json.put("position",1);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==7){
                                            json.put("position",3);
                                            setSerialNumber(json, s1);
                                        }else if(Integer.valueOf(s1.substring(0,1))==8){
                                            json.put("position",2);
                                            setSerialNumber(json, s1);
                                        }
                                        array.add(json);
                                    }

                                }
                                examine.setToothPositions(array.toJSONString());
                            }
                            if(split1.length>1) examine.setResult(split1[1].length()>500?split1[1].substring(0, 500):split1[1]);
                            handleList.add(examine);
                        }
                    }

                    //医嘱
                    cellValue = POIUtil.getCellValue(row.getCell(13));
                    info.setMedicalAdvice(cellValue);
                    //标签
                    cellValue = POIUtil.getCellValue(row.getCell(14));
                    info.setTag(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(15));
                    info.setRemarks(cellValue);

                    info.setImportTime(new Date());
                    list.add(info);
                }
                i++;
            }

            Condition condition = new Condition(Patient.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andIn("cardNumber", cardNumList);
            List<Patient> patients = patientService.findByCondition(condition);
            System.out.println("读取患者");
            Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(Patient::getCardNumber, Patient::getId,(v1,v2)->v1));
            list.forEach(d ->{
                String patientId = patientMap.get(d.getNo());
                if(patientId != null){
                    d.setPatientId(patientId);
                }else{
                    MedicalRecordError error = new MedicalRecordError();
                    BeanUtils.copyProperties(d, error);
                    errorlist.add(error);
                }
            });

            List<Registration> regs = new ArrayList<>();
            List<List<String>> cardNumListPartition = Lists.partition(new ArrayList<>(cardNumList), 5000);
            cardNumListPartition.forEach(data -> {
                Condition condition4 = new Condition(Registration.class);
                Example.Criteria criteria4 = condition4.createCriteria();
                criteria4.andIn("anamnesisNo", cardNumList);
                regs.addAll(registrationService.findByCondition(condition4));
            });

            System.out.println("读取预约");


            Map<String, List<Registration>> registratioMap = regs.stream()
                    .collect(Collectors.groupingBy(Registration::getAnamnesisNo, toSortedList(
                            Comparator.comparing(Registration::getAppointmentTime)
                                    .reversed())));
            //Map<String, String> registratioMap = regs.stream().collect(Collectors.groupingBy(v -> v.getAnamnesisNo() + sdf.format(v.getAppointmentTime()) , Registration::getId,(v1,v2)->v1));
           // Map<String, String> registratioMap2 = regs.stream().collect(Collectors.toMap(v -> v.getAnamnesisNo() , Registration::getId,(v1,v2)->v1));

            list.forEach(d ->{
                //String id = registratioMap.get(d.getNo() + sdf.format(d.getCreateDate()));
                List<Registration> registrations = registratioMap.get(d.getNo());
                if(registrations != null && registrations.size() > 0){
                    Iterator<Registration> iterator = registrations.iterator();
                    while(iterator.hasNext() && d.getAppointmentId()==null){
                        Registration next = iterator.next();
                        if(next.getAppointmentTime().before(d.getCreateDate())){
                            d.setAppointmentId(next.getId());
                        }
                    }

                }
                if(d.getAppointmentId()==null && d.getPatientId() != null){
                    MedicalRecordError error = new MedicalRecordError();
                    BeanUtils.copyProperties(d, error);
                    errorlist.add(error);
                }
            });
            Iterator<MedicalRecord> iterator = list.iterator();
            while(iterator.hasNext()){
                MedicalRecord next = iterator.next();
                if(next.getAppointmentId()==null){
                    iterator.remove();
                }
            }

            List<List<MedicalRecord>> medicalRecordList = Lists.partition(list, 5000);
            medicalRecordList.forEach(d -> {
                medicalRecordService.saveUid(d);
            });

            List<List<MedicalRecordTreatmentPlan>> list2 = Lists.partition(treatmentPlanList, 5000);
            list2.forEach(d -> {
                treatmentPlanService.saveUid(d);
            });

            List<List<MedicalRecordHandle>> list3 = Lists.partition(handleList, 5000);
            list3.forEach(d -> {
                handleService.saveUid(d);
            });

            List<List<MedicalRecordDiagnosis>> list4 = Lists.partition(medicalRecordDiagnosisList, 5000);
            list4.forEach(d -> {
                medicalRecordDiagnosisService.saveUid(d);
            });

            List<List<MedicalRecordSupportExamine>> list5 = Lists.partition(supportExamineList, 5000);
            list5.forEach(d -> {
                supportExamineService.saveUid(d);
            });

            List<List<MedicalRecordMonthExamine>> list6 = Lists.partition(monthExamineList, 5000);
            list6.forEach(d -> {
                monthExamineService.saveUid(d);
            });

            List<List<MedicalRecordError>> errorlists = Lists.partition(errorlist, 5000);
            errorlists.forEach(d -> {
                medicalRecordErrorService.saveUid(d);
            });

            List<List<MedicalRecordYw>> ywLists = Lists.partition(ywList, 5000);
            ywLists.forEach(d -> {
                medicalRecordYwService.saveUid(d);
            });


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

    private void setSerialNumber(JSONObject json, String s1 ){
        if("1".equals(s1.substring(1))){
            json.put("serialNumber","A");
        }else if("2".equals(s1.substring(1))){
            json.put("serialNumber","B");
        }else if("3".equals(s1.substring(1))){
            json.put("serialNumber","C");
        }else if("4".equals(s1.substring(1))){
            json.put("serialNumber","D");
        }else if("5".equals(s1.substring(1))){
            json.put("serialNumber","E");
        }
    }
    //收集器
    public <T> Collector<T, ?, List<T>> toSortedList(Comparator<? super T> c) {
        return Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(c)), ArrayList::new);
    }
}
