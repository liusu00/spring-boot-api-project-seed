package com.company.project.service.impl;

import com.company.project.dao.RegistrationProjectRelMapper;
import com.company.project.model.RegistrationProjectRel;
import com.company.project.service.RegistrationProjectRelService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/26.
 */
@Service
@Transactional
public class RegistrationProjectRelServiceImpl extends AbstractService<RegistrationProjectRel> implements RegistrationProjectRelService {
    @Resource
    private RegistrationProjectRelMapper clcRegistrationProjectRelMapper;

}
