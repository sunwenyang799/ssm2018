package com.maven.dao;

import com.maven.pojo.Account;
import org.springframework.stereotype.Repository;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/29 11:16
 */
@Repository("accountDao")
public interface IAccountDao {

     Account findAccountById(Integer id);
}
