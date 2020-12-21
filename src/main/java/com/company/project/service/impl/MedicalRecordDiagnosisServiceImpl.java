package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordDiagnosisMapper;
import com.company.project.model.MedicalRecordDiagnosis;
import com.company.project.service.MedicalRecordDiagnosisService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/16.
 */
@Service
@Transactional
public class MedicalRecordDiagnosisServiceImpl extends AbstractService<MedicalRecordDiagnosis> implements MedicalRecordDiagnosisService {
    @Resource
    private MedicalRecordDiagnosisMapper medicalRecordDiagnosisMapper;

}
