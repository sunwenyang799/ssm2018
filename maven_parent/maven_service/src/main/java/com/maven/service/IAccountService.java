package com.maven.service;

import com.maven.pojo.Account;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/29 13:42
 */
public interface IAccountService {

    Account findAccountById(Integer id);
}
