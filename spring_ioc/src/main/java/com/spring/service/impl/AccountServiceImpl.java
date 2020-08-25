package com.spring.service.impl;


import com.spring.dao.IAccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.factory.BeanFactory;
import com.spring.service.IAccountService;

/**
 * @author lenovo
 * @description: IAccountService实现类
 * @date 2020/8/20 15:12
 */
public class AccountServiceImpl implements IAccountService {

    //  直接new关键字实例化
//    private IAccountDao accountDao  = new AccountDaoImpl();

    //  工厂模式通过反射方式实例化对象
    private IAccountDao accountDao  = (IAccountDao) BeanFactory.getBean("AccountDao");


    public void saveAccount() {
        int i  = 1;
        System.out.println(i);
        accountDao.saveAccount();
        i++;
    }
}
