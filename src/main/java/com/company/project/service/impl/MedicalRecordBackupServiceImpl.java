package com.company.project.service.impl;

import com.company.project.dao.MedicalRecordBackupMapper;
import com.company.project.model.MedicalRecordBackup;
import com.company.project.service.MedicalRecordBackupService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2021/03/07.
 */
@Service
@Transactional
public class MedicalRecordBackupServiceImpl extends AbstractService<MedicalRecordBackup> implements MedicalRecordBackupService {
    @Resource
    private MedicalRecordBackupMapper medicalRecordBackupMapper;

}
