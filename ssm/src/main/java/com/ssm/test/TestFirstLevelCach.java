package com.ssm.test;

import com.ssm.dao.IUserDao;
import com.ssm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author lenovo
 * @description: 测试一级缓存(SqlSession中)
 * @date 2020/8/19 9:46
 */
public class TestFirstLevelCach {

    private SqlSession session;

    private InputStream inputStream;

    private SqlSessionFactory sqlSessionFactory;

    private IUserDao userDao;

    @Before
    public void init(){
        try {
            inputStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(inputStream);
            session = sqlSessionFactory.openSession(true);
            userDao = session.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        session.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试一级缓存(SqlSession中)
     */
    @Test
    public void testFirstLevelCache(){
        User user = userDao.findById(2);
        System.out.println(user);
        //  关闭session清空缓存
//        session.close();
        //直接在同一个session中清空缓存
        session.clearCache();
//        SqlSession session1 = sqlSessionFactory.openSession();
//        userDao = session1.getMapper(IUserDao.class);
        User user1 = userDao.findById(2);
        System.out.println(user1);
        //  User不重写toString比较地址
        System.out.println( user==user1);
    }

    /**
     * 测试当进行update操作时，sqlsession中的一级缓存会如何处理
     */
    @Test
    public void testUpdateFirstLevelCache(){
        User user = userDao.findById(7);
        System.out.println(user);

        //  当sqlsession进行update,insert，delete，commit，clearcache，close操作时会自动清空缓存
        user.setUserName("test update first cache");
        user.setUserBirthday(new Date());
        userDao.updateUser(user);

        User user1  = userDao.findById(7);
        System.out.println(user1);
        
        System.out.println(user==user1);
    }
}
