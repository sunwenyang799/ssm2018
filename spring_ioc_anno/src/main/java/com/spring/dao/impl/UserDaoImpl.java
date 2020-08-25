package com.spring.dao.impl;

import com.spring.dao.IUserDao;
import com.spring.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 11:47 2020/8/22
 * @ Description：IUserDao实现类
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<User> findAllUser() {
        try {
            return queryRunner.query("select * from t_user", new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findUserById(Integer id) {
        try {
            return queryRunner.query("select * from t_user where id = ?", new BeanHandler<User>(User.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(User user) {
        try {
             queryRunner.update("insert into t_user(username,birthday,sex,adress) values(?,?,?,?)", user.getUsername(),
                    user.getBirthday(),user.getSex(),user.getAdress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        try {
            queryRunner.update("update t_user set username = ?,birthday = ?,sex = ?,adress = ? where id = ?",
                    user.getUsername(), user.getBirthday(),user.getSex(),user.getAdress(),user.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(Integer id) {
        try {
            queryRunner.update("delete from t_user where id = ?",id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
