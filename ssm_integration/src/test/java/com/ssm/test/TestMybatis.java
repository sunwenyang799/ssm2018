package com.ssm.test;

import com.ssm.dao.IAccountDao;
import com.ssm.pojo.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/28 14:36
 */
public class TestMybatis {

    @Test
     public  void test() throws IOException {
//        InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("mybatisConfig.xml");
////        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
////        SqlSession sqlSession = sqlSessionFactory.openSession(true);
////        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
//////        查询所有
////        List<Account> list = accountDao.findAll();
////        for (Account account : list) {
////            System.out.println(account);
////        }
//////        保存
////        Account account = new Account();
////        account.setName("test Mybatis");
////        account.setMoney(10000.0);
////        accountDao.saveAccount(account);
////        sqlSession.close();
////        inputStream.close();
    }
}
