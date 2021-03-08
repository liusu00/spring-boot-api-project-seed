package com.company.project.service;
import com.company.project.model.MedicalRecord;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/11/10.
 */
public interface MedicalRecordService extends Service<MedicalRecord> {

    void batchBlUpdate(List<MedicalRecord> medicalRecordList);
}
