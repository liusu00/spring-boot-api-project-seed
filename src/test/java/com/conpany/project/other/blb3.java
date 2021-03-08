package com.conpany.project.other;

import com.company.project.model.MedicalRecord;
import com.company.project.model.MedicalRecordBackup;
import com.company.project.model.Patient;
import com.company.project.model.Registration;
import com.company.project.service.MedicalRecordBackupService;
import com.company.project.service.MedicalRecordService;
import com.company.project.service.PatientService;
import com.company.project.service.RegistrationService;
import com.conpany.project.Tester;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class blb3 extends Tester {

    @Autowired
    private MedicalRecordBackupService backupService;

    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private RegistrationService registrationService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    @Rollback(false)
    public void importAll() throws Exception{

        Condition condition2 = new Condition(MedicalRecord.class);
        Example.Criteria criteria2 = condition2.createCriteria();
        criteria2.andIsNull("appointmentId");
        criteria2.andIsNotNull("importTime");
        List<MedicalRecord> medicalRecordList = medicalRecordService.findByCondition(condition2);

        Set<String> ids = medicalRecordList.stream().map(MedicalRecord::getPatientId).collect(Collectors.toSet());



        Condition condition3 = new Condition(Registration.class);
        Example.Criteria criteria3 = condition3.createCriteria();
        criteria3.andIn("patientId", ids);
        List<Registration> regs = registrationService.findByCondition(condition3);
        Map<String, String> regsMap = regs.stream().collect(Collectors.toMap(v-> v.getPatientId() + sdf2.format(v.getAppointmentTime()), Registration::getId, (v1,v2)->v1));


        List<Patient> patients = new ArrayList<>();
        List<List<String>> patientsPartition = Lists.partition(new ArrayList<>(ids), 300);
        patientsPartition.forEach(data -> {
            Condition condition4 = new Condition(Registration.class);
            Example.Criteria criteria4 = condition4.createCriteria();
            criteria4.andIn("id", data);
            patients.addAll(patientService.findByCondition(condition4));
        });
        Map<String, String> patientMap = patients.stream().collect(Collectors.toMap(Patient::getId, Patient::getCardNumber,(v1,v2)->v1));

        Set<String> names = patients.stream().map(Patient::getName).collect(Collectors.toSet());

        Condition condition = new Condition(MedicalRecordBackup.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andIn("name", names);
        List<MedicalRecordBackup> backupList = backupService.findByCondition(condition);
        Map<String, Date> backupMap = backupList.stream().collect(Collectors.toMap(v-> v.getBlh() + sdf2.format(v.getCjsj()), MedicalRecordBackup::getJzsj,(v1,v2)->v1));
        int i = 0;
        for (MedicalRecord medicalRecord : medicalRecordList) {
            String no = patientMap.get(medicalRecord.getPatientId());
            Date jzsj = backupMap.get(no + sdf2.format(medicalRecord.getCreateDate()));
            if(jzsj != null){
                String id = regsMap.get(medicalRecord.getPatientId() + sdf2.format(jzsj));
                if(id != null){
                    System.out.println("id: "+id);
                    System.out.println(i++);
                }
                medicalRecord.setAppointmentId(id);
            }

        }
        List<List<MedicalRecord>> ssss = Lists.partition(medicalRecordList, 2000);
        ssss.forEach(data -> {
            medicalRecordService.batchBlUpdate(data);

        });


    }

}
