package com.ssm.dao.impl;

import com.ssm.dao.IUserDao;
import com.ssm.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ Author     ：swy.
 * @ Date       ：Created in 22:01 2020/8/13
 * @ Description：测试dao如果有实现类如何实现
 */
public class IUserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    @Override
    public List<User> findAll() {
        //   获取session对象
        SqlSession session = factory.openSession();
        List<User> list = session.selectList("com.ssm.dao.IUserDao.findAll");
        return list;
    }
}
