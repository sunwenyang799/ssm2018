package com.ssm.test;

import com.ssm.dao.IAccountDao1;
import com.ssm.dao.IUserDao1;
import com.ssm.pojo.Account;
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
 * @ Author     ：swy
 * @ Date       ：Created in 21:18 2020/8/18
 * @ Description：测试多表懒加载
 */
public class TestLazyLoading {

    private SqlSession session;

    private InputStream inputStream;

    private IAccountDao1 accountDao;

    private IUserDao1 userDao1;

    @Before
    public void init(){
        try {
            inputStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
            session = sqlSessionFactory.openSession(true);
            accountDao = session.getMapper(IAccountDao1.class);
            userDao1 = session.getMapper(IUserDao1.class);
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
            //  
//            System.out.println(account.toString());
//            System.out.println(account.getUser().toString());
        }
    }

    /**
     * 测试查询所有用户，同时还要获取到当前用户的所有账户信息(多对多关系映射)
     */
    @Test
    public void testFindAllUser(){
        List<User1> list = userDao1.findAll();
        for (User1 user1 : list) {
            System.out.println(user1.getUsername());
//            System.out.println(user1.getAccountList().toString());
        }
    }
}
