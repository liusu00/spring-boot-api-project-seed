package com.company.project.service.impl;

import com.company.project.dao.CounselItemsMapper;
import com.company.project.model.CounselItems;
import com.company.project.service.CounselItemsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/17.
 */
@Service
@Transactional
public class CounselItemsServiceImpl extends AbstractService<CounselItems> implements CounselItemsService {
    @Resource
    private CounselItemsMapper clcCounselItemsMapper;

}
