package com.spring.service;

import com.spring.pojo.Account;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:53 2020/8/22
 * @ Description：
 */
public interface IAccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName  转入账户名称
     * @param money 金额
     */
    void transfer(String sourceName,String targetName,Double money);
}
