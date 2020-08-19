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
import java.util.Date;
import java.util.List;

/**
 * @author lenovo
 * @description: 测试mybatis注解单表CRUD
 * @date 2020/8/19 13:30
 */
public class TestAnnoCRUD {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public  void init() throws  Exception{
        inputStream  = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory(){
        sqlSession.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setAdress("大连市");
        user.setUsername("test annotation insert");

        userDao.SaveUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("test annotation update");
        user.setAdress("大连,update");
        user.setId(9);
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.UpdateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(100);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(9);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername(){
        List<User> list = userDao.findUserByUsername("%update%");
        //  字符串拼接方式
//        List<User> list = userDao.findUserByUsername("update");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
