package com.company.project.service.impl;

import com.company.project.dao.SubscribeTypeConfigMapper;
import com.company.project.model.SubscribeTypeConfig;
import com.company.project.service.SubscribeTypeConfigService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2020/11/26.
 */
@Service
@Transactional
public class SubscribeTypeConfigServiceImpl extends AbstractService<SubscribeTypeConfig> implements SubscribeTypeConfigService {
    @Resource
    private SubscribeTypeConfigMapper conSubscribeTypeConfigMapper;

}
