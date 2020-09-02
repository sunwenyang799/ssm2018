package com.ssm.service;

import com.ssm.pojo.Account;

import java.util.List;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/28 11:11
 */
public interface IAccountService {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);
}
