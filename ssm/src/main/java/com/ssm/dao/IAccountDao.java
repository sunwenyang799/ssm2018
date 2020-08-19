package com.ssm.dao;

import com.ssm.pojo.Account;
import com.ssm.pojo.AcountUser;

import java.util.List;

/**
 * @author lenovo
 * @description: account接口dao
 * @date 2020/8/18 11:28
 */
public interface IAccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息(一对一关系映射)
     */
    List<Account> findAll();

    /**
     * 通过创建封装对象的方式获取账户和当前账户所属用户信息
     * @return
     */
    List<AcountUser> findAllByAcountuser();

}
