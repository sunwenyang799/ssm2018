package com.spring.test;

import com.spring.pojo.User;
import com.spring.service.IAccountService;
import com.spring.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 12:24 2020/8/22
 * @ Description：测试xml的Ioc
 */
public class TestXmlIoc {



    @Test
    public void testFindAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xmlBean.xml");
        IUserService userService = context.getBean("userService", IUserService.class);
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlBean.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        User user = userService.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void testSaveUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlBean.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        User user = new User();
        user.setAdress("辽宁");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("test Ioc");
        userService.saveUser(user);
    }

    @Test
    public void testUpdateUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlBean.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        User user = new User();
        user.setAdress("辽宁ioc");
        user.setBirthday(new Date());
        user.setSex("男ioc ");
        user.setUsername("test update  Ioc");
        user.setId(15);
        userService.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlBean.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        userService.deleteUser(15);
    }
}
