package com.mybatis;

import com.mybatis.dao.IUserDao;
import com.mybatis.dao.IUserDao1;
import com.mybatis.pojo.User1;
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
 * @description: 测试注解CRUD(实体类属性与数据库列名不一致)
 * @date 2020/8/19 14:34
 */
public class TestAnnoCRUD1 {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao1 userDao;

    @Before
    public  void init() throws  Exception{
        inputStream  = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao1.class);
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
    public void findAll(){
        List<User1> list = userDao.findAll();
        for (User1 user1 : list) {
            System.out.println(user1);
        }
    }

    @Test
    public void testSaveUser(){
        User1 user = new User1();
        user.setUserAdress("大连市");
        user.setUserName("test annotation insert");

        userDao.SaveUser(user);
    }

    @Test
    public void testUpdateUser(){
        User1 user = new User1();
        user.setUserName("test annotation update");
        user.setUserAdress("大连,update");
        user.setUserId(9);
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        userDao.UpdateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(100);
    }

    @Test
    public void testFindUserById(){
        User1 user = userDao.findUserById(9);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername(){
        List<User1> list = userDao.findUserByUsername("%update%");
        //  字符串拼接方式
//        List<User1> list = userDao.findUserByUsername("update");
        for (User1 user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
