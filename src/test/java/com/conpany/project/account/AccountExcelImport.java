package com.conpany.project.account;

import com.company.project.model.*;
import com.company.project.service.*;
import com.conpany.project.Tester;

import com.conpany.project.util.POIUtil;
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
import java.util.*;
import java.util.stream.Collectors;

public class AccountExcelImport extends Tester {


    @Autowired
    private PatientService patientService;

    @Autowired
    private AccountService accountService;


    @Test
    @Rollback(false)
    public void imports() {

        String filePath = "C:\\Users\\liusu\\Desktop\\提交资料\\账单3\\储值卡余额报表20201207.xls";
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
            ArrayList<Account> list = new ArrayList();
            ArrayList<String> cardNumList = new ArrayList();
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
                    Account info = new Account();
                    info.setCardNum(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(3));
                    info.setName(cellValue);
                    //余额
                    Double numericCellValue = row.getCell(13).getNumericCellValue() *100;
                    info.setBalance(numericCellValue.intValue());
                    info.setUsableBalance(numericCellValue.intValue());
                    //赠送金额
                    numericCellValue = row.getCell(14).getNumericCellValue() *100;
                    info.setGiveAmount(numericCellValue.intValue());
                    list.add(info);
                }
                i++;
            }
            System.out.println("开始...");
            Condition condition = new Condition(Patient.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andIn("cardNumber", cardNumList);
            criteria.andIsNotNull("cardNumber");
            List<Patient> patients = patientService.findByCondition(condition);
            System.out.println("读取患者完毕...");
            Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(v->v.getName() + v.getCardNumber(), Patient::getId,(v1,v2)->v1));
            for (Account account : list) {
                String patientId = patientMap.get(account.getName() + account.getCardNum());
                account.setUserId(patientId);
                account.setUpdateDate(new Date());
            }
            accountService.batchUpdate(list);


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
