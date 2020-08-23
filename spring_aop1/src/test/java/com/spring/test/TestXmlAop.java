package com.spring.test;

import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 17:50 2020/8/23
 * @ Description：测试xml的aop
 */
public class TestXmlAop {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deleteAccount();
    }
}
