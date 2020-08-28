package com.ssm.dao;

import com.ssm.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/28 11:12
 */
@Repository("accountDao")
public interface IAccountDao {

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

