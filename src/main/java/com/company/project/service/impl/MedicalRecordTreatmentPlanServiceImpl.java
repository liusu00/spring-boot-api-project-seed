package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordTreatmentPlanMapper;
import com.company.project.model.MedicalRecordTreatmentPlan;
import com.company.project.service.MedicalRecordTreatmentPlanService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/16.
 */
@Service
@Transactional
public class MedicalRecordTreatmentPlanServiceImpl extends AbstractService<MedicalRecordTreatmentPlan> implements MedicalRecordTreatmentPlanService {
    @Resource
    private MedicalRecordTreatmentPlanMapper medicalRecordTreatmentPlanMapper;

}
