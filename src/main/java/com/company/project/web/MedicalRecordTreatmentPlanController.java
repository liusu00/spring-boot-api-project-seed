package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MedicalRecordTreatmentPlan;
import com.company.project.service.MedicalRecordTreatmentPlanService;
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
@RequestMapping("/medical/record/treatment/plan")
public class MedicalRecordTreatmentPlanController {
    @Resource
    private MedicalRecordTreatmentPlanService medicalRecordTreatmentPlanService;

    @PostMapping("/add")
    public Result add(MedicalRecordTreatmentPlan medicalRecordTreatmentPlan) {
        medicalRecordTreatmentPlanService.save(medicalRecordTreatmentPlan);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        medicalRecordTreatmentPlanService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MedicalRecordTreatmentPlan medicalRecordTreatmentPlan) {
        medicalRecordTreatmentPlanService.update(medicalRecordTreatmentPlan);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MedicalRecordTreatmentPlan medicalRecordTreatmentPlan = medicalRecordTreatmentPlanService.findById(id);
        return ResultGenerator.genSuccessResult(medicalRecordTreatmentPlan);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MedicalRecordTreatmentPlan> list = medicalRecordTreatmentPlanService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
