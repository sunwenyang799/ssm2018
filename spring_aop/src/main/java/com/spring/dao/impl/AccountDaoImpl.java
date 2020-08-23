package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import com.spring.pojo.Account;
import com.spring.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:51 2020/8/22
 * @ Description：
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from t_account1", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from t_account1 where id = ?", new BeanHandler<Account>(Account.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"insert into t_account1(name,money) values(?，?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"update t_account1 set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),
                    account.getId()
                   );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"delete from t_account1 where id = ?",id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account getAccountByName(String name) {
        try {
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(),"select * from t_account1 where name = ?", new BeanListHandler<Account>(Account.class), name);
            if(accounts == null || accounts.size() ==0){
                return null;
            }
            if(accounts.size()>1){
                throw  new RuntimeException("名称不合法，有多个账户存在");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
