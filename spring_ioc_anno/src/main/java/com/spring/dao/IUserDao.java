package com.spring.dao;

import com.spring.pojo.User;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 11:45 2020/8/22
 * @ Description：User持久层
 */
public interface IUserDao {

    List<User> findAllUser();

    User findUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}
