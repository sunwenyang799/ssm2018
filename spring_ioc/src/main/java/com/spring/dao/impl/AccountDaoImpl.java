package com.spring.dao.impl;


import com.spring.dao.IAccountDao;
import com.spring.service.impl.AccountServiceImpl;

/**
 * @author lenovo
 * @description: IAccountDao实现类
 * @date 2020/8/20 15:10
 */
public class AccountDaoImpl implements IAccountDao {

    // 验证ApplicationContext和BeanFactory创建对象策略
    public AccountDaoImpl(){
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void saveAccount() {
        System.out.println("保存成功");
    }

}
