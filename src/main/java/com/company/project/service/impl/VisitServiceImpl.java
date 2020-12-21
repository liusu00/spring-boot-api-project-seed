package com.company.project.service.impl;

import com.company.project.dao.VisitMapper;
import com.company.project.model.Visit;
import com.company.project.service.VisitService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/24.
 */
@Service
@Transactional
public class VisitServiceImpl extends AbstractService<Visit> implements VisitService {
    @Resource
    private VisitMapper clcVisitMapper;

}
