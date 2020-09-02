package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.pojo.Account;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/28 11:14
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层findAll方法执行了");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层saveAccount方法执行了");
        accountDao.saveAccount(account);
        //测试事务控制
//        int a  = 10/0;
//        Account error = new Account();
//        error.setName("error");
//        error.setMoney(100.0);
//        accountDao.saveAccount(error);
    }

}
