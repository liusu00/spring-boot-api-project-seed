package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordSupportExamineMapper;
import com.company.project.model.MedicalRecordSupportExamine;
import com.company.project.service.MedicalRecordSupportExamineService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/16.
 */
@Service
@Transactional
public class MedicalRecordSupportExamineServiceImpl extends AbstractService<MedicalRecordSupportExamine> implements MedicalRecordSupportExamineService {
    @Resource
    private MedicalRecordSupportExamineMapper medicalRecordSupportExamineMapper;

}
