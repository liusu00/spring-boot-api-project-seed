package com.company.project.service.impl;

import com.company.project.dao.PatientSourceMapper;
import com.company.project.model.PatientSource;
import com.company.project.service.PatientSourceService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2020/11/12.
 */
@Service
@Transactional
public class PatientSourceServiceImpl extends AbstractService<PatientSource> implements PatientSourceService {
    @Resource
    private PatientSourceMapper clcPatientSourceMapper;

    @Override
    public List<Map> findIdAndName() {
        return clcPatientSourceMapper.findIdAndName();
    }
}
