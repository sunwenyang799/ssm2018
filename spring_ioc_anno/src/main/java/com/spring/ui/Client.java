package com.spring.ui;

import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author lenovo
 * @description:模拟表现层，调用业务层
 * @date 2020/8/21 15:46
 */
public class Client {


    public static void main(String[] args){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
//        IAccountService accountService1 = applicationContext.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
        applicationContext.close();
//        System.out.println(accountService == accountService1);
//        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
//        System.out.println(accountDao);
    }
}
