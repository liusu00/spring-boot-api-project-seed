package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordErrorMapper;
import com.company.project.model.MedicalRecordError;
import com.company.project.service.MedicalRecordErrorService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2021/03/06.
 */
@Service
@Transactional
public class MedicalRecordErrorServiceImpl extends AbstractService<MedicalRecordError> implements MedicalRecordErrorService {
    @Resource
    private MedicalRecordErrorMapper medicalRecordErrorMapper;

}
