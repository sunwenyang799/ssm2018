package com.spring.dao;

import com.spring.pojo.Account;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/25 11:05
 */
public interface IAccountDao {

    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);

}
