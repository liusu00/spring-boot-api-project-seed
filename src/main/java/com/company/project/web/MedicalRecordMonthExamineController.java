package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordMonthExamine;
import com.company.project.service.MedicalRecordMonthExamineService;
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
@RequestMapping("/medical/record/month/examine")
public class MedicalRecordMonthExamineController {
    @Resource
    private MedicalRecordMonthExamineService medicalRecordMonthExamineService;

    @PostMapping("/add")
    public Result add(MedicalRecordMonthExamine medicalRecordMonthExamine) {
        medicalRecordMonthExamineService.save(medicalRecordMonthExamine);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordMonthExamineService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordMonthExamine medicalRecordMonthExamine) {
        medicalRecordMonthExamineService.update(medicalRecordMonthExamine);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordMonthExamine medicalRecordMonthExamine = medicalRecordMonthExamineService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordMonthExamine);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordMonthExamine> list = medicalRecordMonthExamineService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
