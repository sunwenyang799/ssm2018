package com.spring.ui;

import com.spring.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lenovo
 * @description: 创建bean的三种方式、bean的作用范围
 * @date 2020/8/21 9:37
 */
public class CreateBeanClient {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
        IAccountDao accountDao1 = applicationContext.getBean("accountDao",IAccountDao.class);
//        accountDao.saveAccount();
        System.out.println(accountDao);
        System.out.println(accountDao1);
        //  true 工厂生产的bean默认是单例的 singleton
        System.out.println(accountDao == accountDao1);
    }
}
