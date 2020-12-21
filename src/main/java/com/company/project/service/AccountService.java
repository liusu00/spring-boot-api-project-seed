package com.company.project.service;
import com.company.project.model.Account;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by Su Liu on 2020/11/18.
 */
public interface AccountService extends Service<Account> {

    void batchUpdate(List<Account> list);
}
