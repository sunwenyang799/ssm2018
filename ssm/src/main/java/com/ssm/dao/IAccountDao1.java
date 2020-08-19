package com.ssm.dao;

import com.ssm.pojo.Account;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:05 2020/8/18
 * @ Description：一对一关系延迟加载
 */
public interface IAccountDao1 {

    List<Account> findAll();

    /**
     *根据用户的id查询对应的account,用于多对多延迟加载
     * @return
     */
    List<Account > findByUserId(Integer id);
}
