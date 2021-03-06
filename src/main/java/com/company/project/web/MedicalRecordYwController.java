package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordYw;
import com.company.project.service.MedicalRecordYwService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Su Liu on 2021/03/06.
*/
@RestController
@RequestMapping("/medical/record/yw")
public class MedicalRecordYwController {
    @Resource
    private MedicalRecordYwService medicalRecordYwService;

    @PostMapping("/add")
    public Result add(MedicalRecordYw medicalRecordYw) {
        medicalRecordYwService.save(medicalRecordYw);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordYwService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordYw medicalRecordYw) {
        medicalRecordYwService.update(medicalRecordYw);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordYw medicalRecordYw = medicalRecordYwService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordYw);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordYw> list = medicalRecordYwService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
