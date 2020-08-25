package com.spring.controller;


import com.spring.dao.IAccountDao;
import com.spring.factory.BeanFactory;
import com.spring.service.IAccountService;
import com.spring.service.impl.AccountServiceImpl;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/20 15:14
 */
public class AccountController {

    //  直接new关键字实例化(成员变量变量单例模式)
//    private static IAccountService accountService = new AccountServiceImpl();

    //  工厂模式通过反射方式实例化对象(成员变量使用单例模式)
//    private static IAccountService accountService = (IAccountService) BeanFactory.getBean("AccountService");

    public static void main(String[] args){
        for (int i = 0; i <5; i++) {
            //  多例模式
            IAccountService accountService = (IAccountService) BeanFactory.getBean("AccountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
