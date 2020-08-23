package com.spring.service;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 17:14 2020/8/23
 * @ Description：
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();

}
