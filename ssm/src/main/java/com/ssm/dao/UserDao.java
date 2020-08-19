package com.ssm.dao;

import com.ssm.pojo.User;
import com.ssm.pojo.User1;

import java.util.List;

/**
 * @author lenovo
 * @description: 使用实现类的方式实现mybatis的curd
 * @date 2020/8/17 10:39
 */
public interface UserDao {

    List<User1> findAll();

    /**
     * 保存user
     * @param user
     */
    void saveUser(User1 user);

    /**
     * 更新user
     * @param user
     */
    void updateUser(User1 user);

    /**
     * 删除user
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询user
     * @param id
     * @return
     */
    User1 findById(Integer id);

    /**
     * 根据username模糊查询
     * @param username
     * @return
     */
    List<User1> findByUsername(String username);

    /**
     * 查询总记录条数
     * @return
     */
    int findTotal();
}
