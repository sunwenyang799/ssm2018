package com.spring.factory;

import com.spring.dao.IAccountDao;
import com.spring.dao.impl.AccountDaoImpl;

/**
 * @author lenovo
 * @description: 模拟引入外部jar包的工厂类(该类是存在于jar包中的，无法修改源码的方式提供默认构造函数)
 * @date 2020/8/21 9:47
 */
public class StaticInstanceFactory {

    public static IAccountDao getAccountDao(){
        return new AccountDaoImpl();
    }
}
