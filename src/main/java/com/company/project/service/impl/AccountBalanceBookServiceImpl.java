package com.company.project.service.impl;

import com.company.project.dao.AccountBalanceBookMapper;
import com.company.project.model.Account;
import com.company.project.model.AccountBalanceBook;
import com.company.project.service.AccountBalanceBookService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Su Liu on 2020/11/19.
 */
@Service
@Transactional
public class AccountBalanceBookServiceImpl extends AbstractService<AccountBalanceBook> implements AccountBalanceBookService {
    @Resource
    private AccountBalanceBookMapper accountBalanceBookMapper;



}
