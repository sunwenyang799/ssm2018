package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/21 15:45
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {


    public void saveAccount() {
        System.out.println("accountDao保存了账户");
    }
}
