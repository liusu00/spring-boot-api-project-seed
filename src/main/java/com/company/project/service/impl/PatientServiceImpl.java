package com.company.project.service.impl;

import com.company.project.dao.PatientMapper;
import com.company.project.model.Patient;
import com.company.project.service.PatientService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/11.
 */
@Service
@Transactional
public class PatientServiceImpl extends AbstractService<Patient> implements PatientService {
    @Resource
    private PatientMapper clcPatientTestMapper;

}
