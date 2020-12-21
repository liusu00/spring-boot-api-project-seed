package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CounselItemsRel;
import com.company.project.service.CounselItemsRelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Su Liu on 2020/11/17.
*/
@RestController
@RequestMapping("/counsel/items/rel")
public class CounselItemsRelController {
    @Resource
    private CounselItemsRelService counselItemsRelService;

    @PostMapping("/add")
    public Result add(CounselItemsRel counselItemsRel) {
        counselItemsRelService.save(counselItemsRel);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        counselItemsRelService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CounselItemsRel counselItemsRel) {
        counselItemsRelService.update(counselItemsRel);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        CounselItemsRel counselItemsRel = counselItemsRelService.findById(id);
        return ResultGenerator.genSuccessResult(counselItemsRel);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CounselItemsRel> list = counselItemsRelService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
