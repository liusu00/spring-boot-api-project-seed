package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.RegistrationProjectRel;
import com.company.project.service.RegistrationProjectRelService;
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
@RequestMapping("/registration/project/rel")
public class RegistrationProjectRelController {
    @Resource
    private RegistrationProjectRelService registrationProjectRelService;

    @PostMapping("/add")
    public Result add(RegistrationProjectRel registrationProjectRel) {
        registrationProjectRelService.save(registrationProjectRel);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        registrationProjectRelService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(RegistrationProjectRel registrationProjectRel) {
        registrationProjectRelService.update(registrationProjectRel);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        RegistrationProjectRel registrationProjectRel = registrationProjectRelService.findById(id);
        return ResultGenerator.genSuccessResult(registrationProjectRel);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RegistrationProjectRel> list = registrationProjectRelService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
