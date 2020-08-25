package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.pojo.Account;
import com.spring.service.IAccountService;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/25 11:08
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String sourceName, String targetName, Double money) {

        Account sourceAccount = accountDao.findAccountByName(sourceName);
        Account targetAccount = accountDao.findAccountByName(targetName);

        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        targetAccount.setMoney(targetAccount.getMoney()+money);

        accountDao.updateAccount(sourceAccount);
        int i = 1/0;
        accountDao.updateAccount(targetAccount);
    }
}
