package com.ssm.dao;

import com.ssm.pojo.User;

import java.util.List;

/**
 * @author lenovo
 * @version 1.0
 * @description:
 * @date 2020/8/13 16:55
 */
public interface IUserDao {

     List<User> findAll();
}
