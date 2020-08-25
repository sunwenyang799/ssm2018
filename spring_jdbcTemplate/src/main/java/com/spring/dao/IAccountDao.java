package com.spring.dao;

import com.spring.pojo.Account;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:25 2020/8/24
 * @ Description：
 */
public interface IAccountDao {

    Account getAccountById(Integer id);

    Account getAccountByName(String name);

    void updateAccount(Account account);
}
