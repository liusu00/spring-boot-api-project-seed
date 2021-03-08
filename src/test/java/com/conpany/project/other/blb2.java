package com.conpany.project.other;

import com.company.project.model.*;
import com.company.project.service.MedicalRecordBackupService;
import com.company.project.service.MedicalRecordService;
import com.company.project.service.PatientService;
import com.conpany.project.Tester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 比对两个表的数据： medical_record 和 medical_record_backup
 */
public class blb2 extends Tester {

    @Autowired
    private MedicalRecordBackupService backupService;

    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private PatientService patientService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    @Rollback
    public void importAll() {

        Condition condition = new Condition(MedicalRecordBackup.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("clinic", "优享国际口腔八方门诊部");
        List<MedicalRecordBackup> backupList = backupService.findByCondition(condition);
        System.out.println("backupList" + backupList.size());

        Set<String> names = backupList.stream().map(v->v.getName()).collect(Collectors.toSet());
        System.out.println("names" + names.size());
        Set<String> cardNumList = backupList.stream().map(MedicalRecordBackup::getBlh).collect(Collectors.toSet());
        System.out.println("cardNumList" + cardNumList.size());

        Condition condition3 = new Condition(Patient.class);
        Example.Criteria criteria3 = condition3.createCriteria();
        criteria3.andIn("cardNumber", cardNumList);
        List<Patient> patients = patientService.findByCondition(condition3);
        System.out.println("读取患者");
        Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(Patient::getId, Patient::getName,(v1,v2)->v1));

        Map<String, List<MedicalRecordBackup>> backupMap  = backupList.stream()
                .collect(Collectors.groupingBy(v->v.getName()));

        Condition condition2 = new Condition(MedicalRecord.class);
        Example.Criteria criteria2 = condition2.createCriteria();
        criteria2.andEqualTo("clinicId", "0cdc709140b545958002ce2fe64de3f1");
        criteria2.andIsNotNull("importTime");
        List<MedicalRecord> medicalRecordList = medicalRecordService.findByCondition(condition2);
        for (MedicalRecord medicalRecord : medicalRecordList) {
            if(patientMap.get(medicalRecord.getPatientId()) != null){
                medicalRecord.setName(patientMap.get(medicalRecord.getPatientId()));
            }else{
                medicalRecord.setName(UUID.randomUUID().toString());
            }
        }
        System.out.println("medicalRecordList" + medicalRecordList.size());

        Map<String, List<MedicalRecord>> medicalRecordMap = medicalRecordList.stream()
                .collect(Collectors.groupingBy(v->v.getName()));

        for (String name : names) {
            List<MedicalRecordBackup> list1 = backupMap.get(name);
            List<MedicalRecord> list2 = medicalRecordMap.get(name);
            if(list1 == null){
                System.out.println(name+"list1数据为空");

            }
            if(list2 == null){
                System.out.println(name+"list2数据为空");

            }
            if(list1 != null && list2 != null && list1.size() != list2.size()){
                System.err.println("数据错误：" + name + ", MedicalRecordBackup: " + list1.size() + ", MedicalRecord: " +list2.size());
            }

        }

    }

}
