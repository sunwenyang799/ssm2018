package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import com.spring.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/25 11:06
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findAccountById(Integer id) {
        List<Account> list = getJdbcTemplate().query("select * from t_account1 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.isEmpty() ? null:list.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> list = getJdbcTemplate().query("select * from t_account1 where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if(list.isEmpty()){
            return null;
        }
        if (list.size()>1){
            throw  new RuntimeException("查询结果不唯一");
        }
        return list.get(0);
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update t_account1 set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
