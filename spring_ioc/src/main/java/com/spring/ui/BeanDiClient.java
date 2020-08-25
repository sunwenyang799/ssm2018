package com.spring.ui;

import com.spring.dao.IUserDao;
import com.spring.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lenovo
 * @description: 用于Di的表现层
 * @date 2020/8/21 13:51
 */
public class BeanDiClient {

    /**
     * 用于测试di
     * @param args
     */
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanDI.xml");
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
//        userService.saveUser();

        //  复杂类型的注入/集合的注入
        IUserDao userDao = applicationContext.getBean("userDao", IUserDao.class);
        userDao.saveUser();
    }
}
