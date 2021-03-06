package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordYwMapper;
import com.company.project.model.MedicalRecordYw;
import com.company.project.service.MedicalRecordYwService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2021/03/06.
 */
@Service
@Transactional
public class MedicalRecordYwServiceImpl extends AbstractService<MedicalRecordYw> implements MedicalRecordYwService {
    @Resource
    private MedicalRecordYwMapper medicalRecordYwMapper;

}
