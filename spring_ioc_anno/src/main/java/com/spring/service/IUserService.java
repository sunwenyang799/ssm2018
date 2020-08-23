package com.spring.service;

import com.spring.pojo.User;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 11:48 2020/8/22
 * @ Description：User业务层
 */
public interface IUserService {

    List<User> findAllUser();

    User findUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}
