package com.spring.test;

import com.spring.config.SpringConfiguration;
import com.spring.pojo.User;
import com.spring.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 12:24 2020/8/22
 * @ Description：测试Configuration的Ioc
 *
 * Spring整合Junit的配置
 *      1.导入依赖spring-test
 *      2.使用Junit提供的注解把原有的main方法替换成spring提供的
 *         @RunWith
 *      3.告知spring的运行器，spring的ioc创建是基于xml的还是注解的，并说明位置
 *       @ContextConfiguration
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 *    注意：当使用spring5.x版本时，junit的版本必须在4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestAnnoConfigIoc {

    private ApplicationContext context;

    /**
     * spring整合junit解决代码重复问题：创建spring容器，可以DI
     */
    @Autowired
    private  IUserService userService;


    /**
     * junit解决代码重复太高问题
     */
//    @Before
//    public void init(){
//        context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        userService = context.getBean("userService", IUserService.class);
//    }

    @Test
    public void testFindAll(){
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindOne(){
        User user = userService.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void testSaveUser(){
        List<User> list = userService.findAllUser();
        for (User user : list) {
            System.out.println(user);
        }
        User user = new User();
        user.setAdress("辽宁");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("test Ioc");
        userService.saveUser(user);

        List<User> list1 = userService.findAllUser();
        for (User user1 : list1) {
            System.out.println(user1);
        }
    }

    @Test
    public void testUpdateUser(){
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
        userService.deleteUser(15);
    }
}
