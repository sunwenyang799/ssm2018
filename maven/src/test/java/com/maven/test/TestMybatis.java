package com.maven.test;

import com.maven.dao.IAccountDao;
import com.maven.pojo.Account;
import com.maven.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/29 11:25
 */
public class TestMybatis {

    @Test
     public void testDao(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }
}
