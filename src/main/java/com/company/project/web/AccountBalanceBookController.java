package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.AccountBalanceBook;
import com.company.project.service.AccountBalanceBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Su Liu on 2020/11/19.
*/
@RestController
@RequestMapping("/account/balance/book")
public class AccountBalanceBookController {
    @Resource
    private AccountBalanceBookService accountBalanceBookService;

    @PostMapping("/add")
    public Result add(AccountBalanceBook accountBalanceBook) {
        accountBalanceBookService.save(accountBalanceBook);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        accountBalanceBookService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(AccountBalanceBook accountBalanceBook) {
        accountBalanceBookService.update(accountBalanceBook);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AccountBalanceBook accountBalanceBook = accountBalanceBookService.findById(id);
        return ResultGenerator.genSuccessResult(accountBalanceBook);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<AccountBalanceBook> list = accountBalanceBookService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
