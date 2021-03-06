package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordError;
import com.company.project.service.MedicalRecordErrorService;
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
@RequestMapping("/medical/record/error")
public class MedicalRecordErrorController {
    @Resource
    private MedicalRecordErrorService medicalRecordErrorService;

    @PostMapping("/add")
    public Result add(MedicalRecordError medicalRecordError) {
        medicalRecordErrorService.save(medicalRecordError);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordErrorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordError medicalRecordError) {
        medicalRecordErrorService.update(medicalRecordError);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordError medicalRecordError = medicalRecordErrorService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordError);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordError> list = medicalRecordErrorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
