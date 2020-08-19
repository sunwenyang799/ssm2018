package com.ssm.dao.impl;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author lenovo
 * @description: 使用实现类实现mybatisCURD的实现类
 * @date 2020/8/17 10:41
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<User1> findAll() {
        SqlSession session = sqlSessionFactory.openSession();
        List<User1> list = session.selectList("com.ssm.dao.UserDao.findAll");
        session.close();
        return list;
    }

    @Override
    public void saveUser(User1 user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("com.ssm.dao.UserDao.saveUser",user);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User1 user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.update("com.ssm.dao.UserDao.updateUser",user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUser(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("com.ssm.dao.UserDao.deleteUser",id);
        session.commit();
        session.close();
    }

    @Override
    public User1 findById(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        User1 user1 = session.selectOne("com.ssm.dao.UserDao.findById", id);
        session.close();
        return  user1;
    }

    @Override
    public List<User1> findByUsername(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        List<User1> list = session.selectList("com.ssm.dao.UserDao.findByUsername", "%"+username+"%");
        // 可以在此处拼接% 也可以在传参时拼接%
//        List<User1> list = session.selectList("com.ssm.dao.UserDao.findByUsername", username);
        session.close();
        return  list;
    }

    @Override
    public int findTotal() {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.selectOne("com.ssm.dao.UserDao.findTotal");
        return count;
    }
}
