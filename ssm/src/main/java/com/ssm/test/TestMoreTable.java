package com.ssm.test;

import com.ssm.dao.IAccountDao;
import com.ssm.dao.IRoleDao;
import com.ssm.dao.IUserDao1;
import com.ssm.pojo.Account;
import com.ssm.pojo.AcountUser;
import com.ssm.pojo.Role;
import com.ssm.pojo.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lenovo
 * @description: 测试多表查询(一对一，一对多，多对多)
 * @date 2020/8/18 13:15
 */
public class TestMoreTable {

    private SqlSession session;

    private InputStream inputStream;

    private IAccountDao accountDao;

    private IUserDao1 userDao1;

    private IRoleDao roleDao;

    @Before
    public void init(){
        try {
            inputStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
            session = sqlSessionFactory.openSession(true);
            accountDao = session.getMapper(IAccountDao.class);
            userDao1  = session.getMapper(IUserDao1.class);
            roleDao = session.getMapper(IRoleDao.class);
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
     * 测试查询所有账户，同时还要获取到当前账户的所属用户信息(一对一关系映射)
     */
    @Test
    public void findAllAccount(){
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account.toString());
            System.out.println(account.getUser().toString());
        }
    }

    /**
     * 测试查询所有账户，同时还要获取到当前账户的所属用户信息(封装继承类的方式)
     */
    @Test
    public  void findAllAccountByAcountuser(){
        List<AcountUser> list = accountDao.findAllByAcountuser();
        for (AcountUser acountUser : list) {
            System.out.println(acountUser.toString());
        }
    }

    /**
     * 
     */
    @Test
    public void finAllUser(){
        List<User1> list = userDao1.findAll();
        for (User1 user1 : list) {
            System.out.println(user1.toString());
            System.out.println(user1.getAccountList().toString());
        }
    }

    @Test
    public void findAllRole(){
        List<Role> list = roleDao.findAll();
        for (Role role : list) {
            System.out.println(role.toString());
            System.out.println(role.getUserList().toString());
        }
    }
    
    @Test
    public void findAllUserRole(){
        List<User1> list = userDao1.findAllRole();
        for (User1 user1 : list) {
            System.out.println(user1.toString());
            System.out.println(user1.getRoleList().toString());
        }
    }
}
