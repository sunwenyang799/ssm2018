package com.maven.service.impl;

import com.maven.dao.IAccountDao;
import com.maven.pojo.Account;
import com.maven.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/29 13:43
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }
}
