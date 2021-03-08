package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordBackup;
import com.company.project.service.MedicalRecordBackupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Su Liu on 2021/03/07.
*/
@RestController
@RequestMapping("/medical/record/backup")
public class MedicalRecordBackupController {
    @Resource
    private MedicalRecordBackupService medicalRecordBackupService;

    @PostMapping("/add")
    public Result add(MedicalRecordBackup medicalRecordBackup) {
        medicalRecordBackupService.save(medicalRecordBackup);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordBackupService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordBackup medicalRecordBackup) {
        medicalRecordBackupService.update(medicalRecordBackup);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordBackup medicalRecordBackup = medicalRecordBackupService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordBackup);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordBackup> list = medicalRecordBackupService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
