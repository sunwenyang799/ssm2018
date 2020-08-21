package com.spring.factory;

import com.spring.dao.IAccountDao;
import com.spring.dao.impl.AccountDaoImpl;

/**
 * @author lenovo
 * @description: 模拟引入外部jar包的工厂类(该类是存在于jar包中的，无法修改源码的方式提供默认构造函数)
 * @date 2020/8/21 9:41
 */
public class InstanceFactory {

    /**
     * 模拟想要获取引入jar包中工厂生产的对象
     * @return
     */
    public IAccountDao getAccountDao(){
        return new AccountDaoImpl();
    }
}
