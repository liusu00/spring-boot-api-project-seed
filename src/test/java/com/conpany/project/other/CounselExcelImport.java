package com.conpany.project.other;

import com.company.project.model.*;
import com.company.project.service.*;
import com.conpany.project.Tester;
import com.conpany.project.util.POIUtil;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class CounselExcelImport extends Tester {

    @Autowired
    private PatientService patientService;

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private CounselService counselService;
    @Autowired
    private CounselItemsService counselItemsService;
    @Autowired
    private DictService dictService;
    @Autowired
    private CounselItemsRelService counselItemsRelService;

    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    @Test
    @Rollback(false)
    public void importAll(){
        String[] str = {
                "咨询记录.xls",


        };
        for (String name : str) {
            imports(name);
        }

    }

    public void imports(String name) {
        Condition condition = new Condition(Dict.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("dictTypeId", "619c6533c7ab407890a2834f42404a44");
        List<Dict> byCondition = dictService.findByCondition(condition);
        Map<String, String> dictMap = byCondition.stream().collect(Collectors.toMap(Dict::getLabel, Dict::getValue));

        List<CounselItems> items = counselItemsService.findAll();
        Map<String, String> itemsMap = items.stream().collect(Collectors.toMap(CounselItems::getItemName, CounselItems::getId));

        //String filePath = "C:\\Users\\liusu\\Desktop\\提交资料\\咨询\\新天地-咨询记录-2020.xls";
        String filePath = "F:\\新世界咨询\\"+name;
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
            // 获取第一个sheet表，也可使用sheet表名获取
            Sheet sheet = workbook.getSheetAt(0);
            // 获取行
            Iterator<Row> rows = sheet.rowIterator();
            Row row;
            int i = 0;
            //
            ArrayList<Counsel> list = new ArrayList();
            ArrayList<CounselItemsRel> itemsRelList = new ArrayList();
            ArrayList<String> tels = new ArrayList();
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){

                    Counsel info = new Counsel();
                    info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    info.setDelFlag("0");
                    info.setIgnoreFlag("0");//是否忽略
                    info.setCreateBy("1");
                    info.setCreateDate(new Date());
                    info.setCounselType("1");

                    String cellValue = POIUtil.getCellValue(row.getCell(4));
                    tels.add(cellValue);
                    info.setTel(cellValue);
                    //就诊日期
                    cellValue = POIUtil.getCellValue(row.getCell(7));
                    //info.setRegistrationId(regsMap.get(info.getPatientId()+sdf2.parse(cellValue)));
                    if(!"".equals(cellValue))
                        info.setTime(cellValue);
                    //咨询项目
                    cellValue = POIUtil.getCellValue(row.getCell(11));
                    if(!"".equals(cellValue)){
                        String[] split = cellValue.split(",");
                        for (String s : split) {
                            CounselItemsRel itemsRel = new CounselItemsRel();
                            itemsRel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            itemsRel.setCounselId(info.getId());
                            itemsRel.setItemName(itemsMap.get(s));
                            itemsRelList.add(itemsRel);
                        }
                    }

                    //咨询内容
                    cellValue = POIUtil.getCellValue(row.getCell(12));
                    info.setContext(cellValue);
                    //成交意愿 transaction_intention
                    cellValue = POIUtil.getCellValue(row.getCell(13));
                    info.setTransactionIntention(dictMap.get(cellValue));
                    //备注
                    cellValue = POIUtil.getCellValue(row.getCell(17));
                    info.setRemarks(cellValue);
                    list.add(info);

                }
                i++;
            }


            Condition condition2 = new Condition(Patient.class);
            Example.Criteria criteria2 = condition2.createCriteria();
            criteria2.andIn("telephoneNo", tels);
            List<Patient> patients = patientService.findByCondition(condition2);
            System.out.println("读取患者完毕...");
            Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(t -> t.getTelephoneNo(), Patient::getId,(v1,v2)->v1));

            Condition condition4 = new Condition(Registration.class);
            Example.Criteria criteria4 = condition4.createCriteria();
            criteria4.andIsNotNull("appointmentTime");
            Set<String> ids = patients.stream().map(Patient::getId).collect(Collectors.toSet());
            criteria4.andIn("patientId", ids);
            List<Registration> regs = registrationService.findByCondition(condition4);
            Map<String, String> regsMap = regs.stream().collect(Collectors.toMap(t -> t.getPatientId() + sdf2.format(t.getAppointmentTime()), Registration::getId,(v1,v2)->v1));

            for (Counsel counsel : list) {
                counsel.setPatientId(patientMap.get(counsel.getTel()));
                if(StringUtils.isNotBlank(counsel.getTime()))
                    counsel.setRegistrationId(regsMap.get(counsel.getPatientId()+counsel.getTime()));
            }
            counselService.saveUid(list);
            counselItemsRelService.saveUid(itemsRelList);

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
