package com.company.project.service.impl;

import com.company.project.dao.SmsTemplateMapper;
import com.company.project.model.SmsTemplate;
import com.company.project.service.SmsTemplateService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Su Liu on 2021/01/06.
 */
@Service
@Transactional
public class SmsTemplateServiceImpl extends AbstractService<SmsTemplate> implements SmsTemplateService {
    @Resource
    private SmsTemplateMapper smsTemplateMapper;

}
