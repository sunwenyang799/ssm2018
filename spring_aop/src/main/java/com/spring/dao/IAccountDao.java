package com.spring.dao;

import com.spring.pojo.Account;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:51 2020/8/22
 * @ Description：
 */
public interface IAccountDao {

    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    void saveAccount(Account Account);

    void updateAccount(Account Account);

    void deleteAccount(Integer id);

    Account getAccountByName(String name);
}
