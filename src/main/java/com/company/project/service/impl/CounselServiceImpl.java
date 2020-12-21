package com.company.project.service.impl;

import com.company.project.dao.CounselMapper;
import com.company.project.model.Counsel;
import com.company.project.service.CounselService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/17.
 */
@Service
@Transactional
public class CounselServiceImpl extends AbstractService<Counsel> implements CounselService {
    @Resource
    private CounselMapper clcCounselMapper;

}
