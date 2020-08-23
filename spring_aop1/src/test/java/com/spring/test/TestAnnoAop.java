package com.spring.test;

import com.spring.config.SpringConfig;
import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:49 2020/8/23
 * @ Description：测试注解的aop
 */
public class TestAnnoAop {

    public static void main(String[] args){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_anno.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
    }

}
