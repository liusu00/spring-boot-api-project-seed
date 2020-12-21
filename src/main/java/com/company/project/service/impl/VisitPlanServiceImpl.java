package com.company.project.service.impl;

import com.company.project.dao.VisitPlanMapper;
import com.company.project.model.VisitPlan;
import com.company.project.service.VisitPlanService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/24.
 */
@Service
@Transactional
public class VisitPlanServiceImpl extends AbstractService<VisitPlan> implements VisitPlanService {
    @Resource
    private VisitPlanMapper clcVisitPlanMapper;

}
