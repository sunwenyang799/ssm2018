package com.ssm.dao;

import com.ssm.pojo.User1;

import java.util.List;

/**
 * @author lenovo
 * @description: 多表查询接口
 * @date 2020/8/18 11:23
 */
public interface IUserDao1 {

    /**
     * 查询所有用户信息以及它们的account信息
     * @return
     */
    List<User1> findAll();

    /**
     * 查询所有用户信息以及它们的role信息
     * @return
     */
    List<User1> findAllRole();
}
