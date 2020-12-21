package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordMapper;
import com.company.project.model.MedicalRecord;
import com.company.project.service.MedicalRecordService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/10.
 */
@Service
@Transactional
public class MedicalRecordServiceImpl extends AbstractService<MedicalRecord> implements MedicalRecordService {
    @Resource
    private MedicalRecordMapper medicalRecordTestMapper;

}
