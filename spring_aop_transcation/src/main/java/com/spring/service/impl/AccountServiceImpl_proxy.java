package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.pojo.Account;
import com.spring.service.IAccountService;
import com.spring.utils.TransactionManager;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:53 2020/8/22
 * @ Description：
 */
public class AccountServiceImpl_proxy implements IAccountService {


    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        List<Account> list = accountDao.findAllAccount();
        return list;
    }

    public Account findAccountById(Integer id) {
        Account account = accountDao.findAccountById(id);
        return account;
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void transfer(String sourceName, String targetName, Double money) {
        System.out.println("transfer...");
        //2.1.根据名称查出转出账户
        Account sourceAccount = accountDao.getAccountByName(sourceName);
        //2.2.根据名称查出转入账户
        Account targetAccount = accountDao.getAccountByName(targetName);
        //2.3.转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        //2.4.转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney()+money);
        //2.5.更新转出账户
        accountDao.updateAccount(sourceAccount);

//            int a = 1/0;
        //2.6.更新转入账户
        accountDao.updateAccount(targetAccount);

    }
}
