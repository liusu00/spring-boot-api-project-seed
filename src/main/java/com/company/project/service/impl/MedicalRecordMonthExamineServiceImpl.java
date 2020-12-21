package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordMonthExamineMapper;
import com.company.project.model.MedicalRecordMonthExamine;
import com.company.project.service.MedicalRecordMonthExamineService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/16.
 */
@Service
@Transactional
public class MedicalRecordMonthExamineServiceImpl extends AbstractService<MedicalRecordMonthExamine> implements MedicalRecordMonthExamineService {
    @Resource
    private MedicalRecordMonthExamineMapper medicalRecordMonthExamineMapper;

}
