package com.conpany.project.account;

import com.company.project.model.Account;
import com.company.project.model.AccountBalanceBook;
import com.company.project.model.Patient;
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

public class AccountBookExcelImport extends Tester {

    @Autowired
    private PatientService patientService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountBalanceBookService accountBalanceBookService;


    @Test
    @Rollback(false)
    public void imports() {

        String filePath = "C:\\Users\\liusu\\Desktop\\提交资料\\账单3\\储值卡余额变动记录报表 (3).xls";
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
            ArrayList<AccountBalanceBook> list = new ArrayList();
            ArrayList<String> cardNumList = new ArrayList();
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){

                    //病历号
                    String cellValue = POIUtil.getCellValue(row.getCell(1));
                    if(cellValue == null){
                        continue;
                    }
                    cardNumList.add(cellValue);
                    //本期本金增加
                    if(row.getCell(12).getNumericCellValue()>0){
                        AccountBalanceBook info = new AccountBalanceBook();
                        info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                        info.setCreateBy("asd");
                        info.setCardNum(cellValue);
                        info.setBookType("1");

                        cellValue = POIUtil.getCellValue(row.getCell(0));
                        info.setCahierName(cellValue);

                        cellValue = POIUtil.getCellValue(row.getCell(2));
                        info.setName(cellValue);
                        //本期本金增加
                        Double af = row.getCell(12).getNumericCellValue() * 100;
                        info.setBeforeBalance(0);
                        info.setAfterBalance(af.intValue());
                        info.setBalanceIncurred(af.intValue());

                        Double ga = row.getCell(13).getNumericCellValue() * 100;
                        info.setAfterGiveAmount(0);
                        info.setBeforeGiveAmount(ga.intValue());
                        info.setGiveAmountIncurred(ga.intValue());

                        list.add(info);
                    }

                }
                i++;
            }
            System.out.println("开始...");
            Condition condition = new Condition(Patient.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andIn("cardNumber", cardNumList);
            criteria.andIsNotNull("cardNumber");
            List<Patient> patients = patientService.findByCondition(condition);
            Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(v->v.getName() + v.getCardNumber(), Patient::getId,(v1,v2)->v1));
            System.out.println("读取患者完毕.: "+ patients.size());

            Condition acc = new Condition(Account.class);
            Example.Criteria criteria1 = acc.createCriteria();
            criteria1.andEqualTo("accountType","1");
            List<Account> accountList = accountService.findByCondition(acc);
            Map<String, String> accountMap = accountList.stream().collect(Collectors.toMap(v->v.getUserId() , Account::getId));

            for (AccountBalanceBook account : list) {
                String patientId = patientMap.get(account.getName() + account.getCardNum());
                String accountId = accountMap.get(patientId);
                account.setAccountId(accountId);
            }
            accountBalanceBookService.saveUid(list);

            int j = 0;
            Iterator<Row> rows2 = sheet.rowIterator();
            ArrayList<AccountBalanceBook> list2 = new ArrayList();
            while (rows2.hasNext()) {
                Row row2 = rows2.next();
                // 获取单元格
                if(j>0){

                    //病历号
                    String cellValue = POIUtil.getCellValue(row2.getCell(1));
                    if(cellValue == null){
                        continue;
                    }
                    //本期本金消费
                    if(row2.getCell(14).getNumericCellValue()<0){
                        AccountBalanceBook info = new AccountBalanceBook();
                        info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                        info.setCreateBy("asd");
                        info.setCardNum(cellValue);
                        info.setBookType("5");

                        cellValue = POIUtil.getCellValue(row2.getCell(0));
                        info.setCahierName(cellValue);

                        cellValue = POIUtil.getCellValue(row2.getCell(2));
                        info.setName(cellValue);
                        //本期本金消费
                        Double af = row2.getCell(14).getNumericCellValue() * 100;
                        info.setBalanceIncurred(-af.intValue());

                        Double ga = row2.getCell(15).getNumericCellValue() * 100;
                        info.setGiveAmountIncurred(-ga.intValue());

                        list2.add(info);
                    }

                }
                j++;
            }
            Map<String, AccountBalanceBook> collect = list.stream().collect(Collectors.toMap(v -> v.getName() + v.getCardNum(), v -> v));
            for (AccountBalanceBook book : list2) {
                AccountBalanceBook accountBalanceBook = collect.get(book.getName() + book.getCardNum());
                if(accountBalanceBook != null){
                    book.setAccountId(accountBalanceBook.getAccountId());

                    book.setBeforeBalance(accountBalanceBook.getAfterBalance());
                    book.setAfterBalance(accountBalanceBook.getAfterBalance() - book.getBalanceIncurred());

                    book.setBeforeGiveAmount(accountBalanceBook.getAfterGiveAmount());
                    book.setAfterGiveAmount(accountBalanceBook.getAfterGiveAmount() - book.getGiveAmountIncurred());
                }

            }
            Iterator<AccountBalanceBook> iterator = list2.iterator();
            while(iterator.hasNext()){
                AccountBalanceBook next = iterator.next();
                if(next.getAccountId() == null){
                    iterator.remove();
                }
            }
            accountBalanceBookService.saveUid(list2);

            int k = 0;
            Iterator<Row> rows3 = sheet.rowIterator();
            ArrayList<AccountBalanceBook> list3 = new ArrayList();
            while (rows3.hasNext()) {
                Row row2 = rows3.next();
                // 获取单元格
                if(k>0){

                    //病历号
                    String cellValue = POIUtil.getCellValue(row2.getCell(1));
                    if(cellValue == null){
                        continue;
                    }
                    //本期本金退费
                    if(row2.getCell(16).getNumericCellValue()<0){
                        AccountBalanceBook info = new AccountBalanceBook();
                        info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                        info.setCreateBy("asd");
                        info.setCardNum(cellValue);
                        info.setBookType("4");

                        cellValue = POIUtil.getCellValue(row2.getCell(0));
                        info.setCahierName(cellValue);

                        cellValue = POIUtil.getCellValue(row2.getCell(2));
                        info.setName(cellValue);
                        //本期本金退费
                        Double af = row2.getCell(16).getNumericCellValue() * 100;
                        info.setBalanceIncurred(-af.intValue());

                        Double ga = row2.getCell(17).getNumericCellValue() * 100;
                        info.setGiveAmountIncurred(-ga.intValue());

                        list3.add(info);
                    }

                }
                k++;
            }
            Map<String, AccountBalanceBook>  collect2 = list2.stream().collect(Collectors.toMap(v -> v.getName() + v.getCardNum(), v -> v));
            for (AccountBalanceBook book : list3) {
                AccountBalanceBook accountBalanceBook = collect2.get(book.getName() + book.getCardNum());
                if(accountBalanceBook != null){
                    book.setAccountId(accountBalanceBook.getAccountId());

                    book.setBeforeBalance(accountBalanceBook.getAfterBalance());
                    book.setAfterBalance(accountBalanceBook.getAfterBalance() + book.getBalanceIncurred());

                    book.setBeforeGiveAmount(accountBalanceBook.getAfterGiveAmount());
                    book.setAfterGiveAmount(accountBalanceBook.getAfterGiveAmount() + book.getGiveAmountIncurred());
                }else{
                    accountBalanceBook = collect.get(book.getName() + book.getCardNum());
                    if(accountBalanceBook != null){
                        book.setAccountId(accountBalanceBook.getAccountId());

                        book.setBeforeBalance(accountBalanceBook.getAfterBalance());
                        book.setAfterBalance(accountBalanceBook.getAfterBalance() + book.getBalanceIncurred());

                        book.setBeforeGiveAmount(accountBalanceBook.getAfterGiveAmount());
                        book.setAfterGiveAmount(accountBalanceBook.getAfterGiveAmount() + book.getGiveAmountIncurred());
                    }
                }

            }

            iterator = list3.iterator();
            while(iterator.hasNext()){
                AccountBalanceBook next = iterator.next();
                if(next.getAccountId() == null){
                    iterator.remove();
                }
            }
            accountBalanceBookService.saveUid(list3);

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
