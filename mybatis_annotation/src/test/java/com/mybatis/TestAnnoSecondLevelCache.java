package com.mybatis;

import com.mybatis.dao.IUserDao;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lenovo
 * @description: 测试mybatis注解二级缓存
 * @date 2020/8/19 13:30
 */
public class TestAnnoSecondLevelCache {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public  void init() throws  Exception{
        inputStream  = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void destory(){
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findUserById(9);
        sqlSession1.close();
        System.out.println(user1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = userDao2.findUserById(9);
        sqlSession2.close();
        System.out.println(user2);
        
        System.out.println(user1 == user2);

    }
}
