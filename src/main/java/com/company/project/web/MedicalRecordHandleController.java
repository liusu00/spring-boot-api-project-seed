package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordHandle;
import com.company.project.service.MedicalRecordHandleService;
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
@RequestMapping("/medical/record/handle")
public class MedicalRecordHandleController {
    @Resource
    private MedicalRecordHandleService medicalRecordHandleService;

    @PostMapping("/add")
    public Result add(MedicalRecordHandle medicalRecordHandle) {
        medicalRecordHandleService.save(medicalRecordHandle);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordHandleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordHandle medicalRecordHandle) {
        medicalRecordHandleService.update(medicalRecordHandle);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordHandle medicalRecordHandle = medicalRecordHandleService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordHandle);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordHandle> list = medicalRecordHandleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
