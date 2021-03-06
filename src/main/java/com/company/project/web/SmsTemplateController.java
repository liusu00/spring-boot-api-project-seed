package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SmsTemplate;
import com.company.project.service.SmsTemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Su Liu on 2021/01/06.
*/
@RestController
@RequestMapping("/sms/template")
public class SmsTemplateController {
    @Resource
    private SmsTemplateService smsTemplateService;

    @PostMapping("/add")
    public Result add(SmsTemplate smsTemplate) {
        smsTemplateService.save(smsTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        smsTemplateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SmsTemplate smsTemplate) {
        smsTemplateService.update(smsTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SmsTemplate smsTemplate = smsTemplateService.findById(id);
        return ResultGenerator.genSuccessResult(smsTemplate);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsTemplate> list = smsTemplateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
