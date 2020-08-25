package com.spring.service.impl;

import com.spring.dao.IUserDao;
import com.spring.pojo.User;
import com.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 11:48 2020/8/22
 * @ Description：IUserService实现类
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

//    public void setUserDao(IUserDao userDao) {
//        this.userDao = userDao;
//    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
