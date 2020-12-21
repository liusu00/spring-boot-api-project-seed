package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordSupportExamine;
import com.company.project.service.MedicalRecordSupportExamineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/11/16.
*/
@RestController
@RequestMapping("/medical/record/support/examine")
public class MedicalRecordSupportExamineController {
    @Resource
    private MedicalRecordSupportExamineService medicalRecordSupportExamineService;

    @PostMapping("/add")
    public Result add(MedicalRecordSupportExamine medicalRecordSupportExamine) {
        medicalRecordSupportExamineService.save(medicalRecordSupportExamine);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordSupportExamineService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordSupportExamine medicalRecordSupportExamine) {
        medicalRecordSupportExamineService.update(medicalRecordSupportExamine);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordSupportExamine medicalRecordSupportExamine = medicalRecordSupportExamineService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordSupportExamine);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordSupportExamine> list = medicalRecordSupportExamineService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
