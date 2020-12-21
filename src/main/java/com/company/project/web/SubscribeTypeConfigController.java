package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SubscribeTypeConfig;
import com.company.project.service.SubscribeTypeConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Su Liu on 2020/11/26.
*/
@RestController
@RequestMapping("/subscribe/type/config")
public class SubscribeTypeConfigController {
    @Resource
    private SubscribeTypeConfigService subscribeTypeConfigService;

    @PostMapping("/add")
    public Result add(SubscribeTypeConfig subscribeTypeConfig) {
        subscribeTypeConfigService.save(subscribeTypeConfig);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subscribeTypeConfigService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SubscribeTypeConfig subscribeTypeConfig) {
        subscribeTypeConfigService.update(subscribeTypeConfig);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SubscribeTypeConfig subscribeTypeConfig = subscribeTypeConfigService.findById(id);
        return ResultGenerator.genSuccessResult(subscribeTypeConfig);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SubscribeTypeConfig> list = subscribeTypeConfigService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
