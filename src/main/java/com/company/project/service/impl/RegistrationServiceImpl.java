package com.company.project.service.impl;

import com.company.project.dao.RegistrationMapper;
import com.company.project.model.Registration;
import com.company.project.service.RegistrationService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/11/12.
 */
@Service
@Transactional
public class RegistrationServiceImpl extends AbstractService<Registration> implements RegistrationService {
    @Resource
    private RegistrationMapper clcRegistrationTestMapper;


}
