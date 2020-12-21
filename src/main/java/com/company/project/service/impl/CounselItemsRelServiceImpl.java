package com.company.project.service.impl;

import com.company.project.dao.CounselItemsRelMapper;
import com.company.project.model.CounselItemsRel;
import com.company.project.service.CounselItemsRelService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/17.
 */
@Service
@Transactional
public class CounselItemsRelServiceImpl extends AbstractService<CounselItemsRel> implements CounselItemsRelService {
    @Resource
    private CounselItemsRelMapper clcCounselItemsRelMapper;

}
