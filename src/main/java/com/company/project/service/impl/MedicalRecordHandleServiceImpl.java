package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordHandleMapper;
import com.company.project.model.MedicalRecordHandle;
import com.company.project.service.MedicalRecordHandleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/16.
 */
@Service
@Transactional
public class MedicalRecordHandleServiceImpl extends AbstractService<MedicalRecordHandle> implements MedicalRecordHandleService {
    @Resource
    private MedicalRecordHandleMapper medicalRecordHandleMapper;

}
