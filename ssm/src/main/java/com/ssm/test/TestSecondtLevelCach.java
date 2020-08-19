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
 * @description: 测试二级缓存(SqlSessionFactory)
 * @date 2020/8/19 9:46
 */
public class TestSecondtLevelCach {


    private InputStream inputStream;

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        try {
            inputStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondLevelCache(){
        //  从同一个sqlSessionFactory中创建不同的SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(8);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(8);
        System.out.println(user2);
        sqlSession2.close();

        //  user1和user2的地址不一样,但是内容一样,因为二级缓存中存储的是数据,一级缓存中存储的是对象
        //  一级缓存:user1   user2
        //  二级缓存 {"id":"1","username":"二级缓存1"...}    {"id":"2","username":"二级缓存2"}
        //  二级缓存存储的是select语句的内容,当映射文件中发生insert,update，delete语句是会刷新缓存
        System.out.println(user1 == user2);
    }
}
