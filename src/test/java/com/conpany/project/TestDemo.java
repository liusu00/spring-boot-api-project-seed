package com.conpany.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.model.MedicalRecord;
import com.company.project.model.MedicalRecordMonthExamine;
import com.company.project.model.PatientSource;
import com.company.project.service.PatientSourceService;
import com.conpany.project.util.POIUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestDemo {


    public static void main(String[] args) {
        String a = ";内容：";
        String[] split1 = a.split(";内容：");
        String replace = split1[0];
        System.out.println(replace);
    }

    private static void setSerialNumber(JSONObject json, String s1 ){
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
    }/*
    public static void main(String[] args) {
        String cellValue = "牙位：43,44;内容：33牙冠唇面和34牙冠颊面颈部及牙根部可见缺损，缺损达牙本质中层，探诊敏感，冷测试敏感，无叩痛，余未见异常。,牙位：46;内容：缺失，45,47向缺牙间隙倾斜。,牙位：36,37,47;内容：咬合面可见大面积白色充填物，且牙体有缺损。,牙位：11,12,21,22,23;内容：可见烤瓷牙冠，边缘较密合。";
        cellValue = cellValue.substring(3);
        if(!cellValue.equals("")){
            String[] split = cellValue.split(",牙位：");
            for (String s : split) {
                MedicalRecordMonthExamine examine = new MedicalRecordMonthExamine();
                examine.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                examine.setCreateBy("1");
                examine.setCreateDate(new Date());
                examine.setDelFlag("0");
                examine.setMedicalRecordId("123");

                String[] split1 = s.split(";内容：");
                String yw = split1[0];
                if(!"".equals(yw)){
                    String[] split2 = yw.split(",");
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

                if(split1.length>1)
                    examine.setResult(split1[1].length()>200?split1[1].substring(0, 200):split1[1]);
            }
        }

    }*/
}