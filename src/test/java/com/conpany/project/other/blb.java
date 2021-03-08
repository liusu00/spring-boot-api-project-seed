package com.conpany.project.other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.model.*;
import com.company.project.service.*;
import com.conpany.project.Tester;
import com.conpany.project.util.POIUtil;
import com.google.common.collect.Lists;
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

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 导入管理门户 下载数据
 * 表名称：medical_record_backup
 */
public class blb extends Tester {

    @Autowired
    private MedicalRecordBackupService backupService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    @Rollback(false)
    public void importAll() {
        String filepath = "F:\\新病历数据";
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
            ArrayList<MedicalRecordBackup> list = new ArrayList();

            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                if(i>0){

                    MedicalRecordBackup info = new MedicalRecordBackup();
                    info.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    info.setImportCode(1);
                    info.setImportTime(new Date());

                    String cellValue = POIUtil.getCellValue(row.getCell(0));
                    info.setStatus(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(2)).trim();
                    info.setBlh(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(3));
                    info.setName(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(4));
                    info.setSex(cellValue);
                    //主诉
                    cellValue = POIUtil.getCellValue(row.getCell(5));
                    info.setAge(cellValue);
                    //现病史
                    cellValue = POIUtil.getCellValue(row.getCell(6));
                    if(StringUtils.isNotBlank(cellValue))
                        info.setJzsj(sdf2.parse(cellValue));
                    //既往史
                    cellValue = POIUtil.getCellValue(row.getCell(7));
                    info.setClinic(cellValue);

                    //医嘱
                    cellValue = POIUtil.getCellValue(row.getCell(9));
                    info.setYs(cellValue);
                    //标签
                    cellValue = POIUtil.getCellValue(row.getCell(10));
                    info.setZs(cellValue);

                    cellValue = POIUtil.getCellValue(row.getCell(11));
                    if(StringUtils.isNotBlank(cellValue))
                        info.setCjsj(sdf2.parse(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(12));
                    if(StringUtils.isNotBlank(cellValue))
                        info.setXgsj(sdf2.parse(cellValue));

                    cellValue = POIUtil.getCellValue(row.getCell(13));
                    info.setBllx(cellValue);

                    list.add(info);
                }
                i++;
            }

            List<List<MedicalRecordBackup>> medicalRecordList = Lists.partition(list, 5000);
            medicalRecordList.forEach(d -> {
                backupService.saveUid(d);
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


}
