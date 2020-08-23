package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.pojo.Account;
import com.spring.service.IAccountService;
import com.spring.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 19:53 2020/8/22
 * @ Description：
 */
public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> list = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果集
            return list;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.release();
        }
    }

    public Account findAccountById(Integer id) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(id);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果集
            return account;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //4.事务回滚
            transactionManager.rollback();
        }finally {
            //5.释放资源
            transactionManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //4.事务回滚
            transactionManager.rollback();
        }finally {
            //5.释放资源
            transactionManager.release();
        }
    }

    public void deleteAccount(Integer id) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //4.事务回滚
            transactionManager.rollback();
        }finally {
            //5.释放资源
            transactionManager.release();
        }

    }

    public void transfer(String sourceName, String targetName, Double money) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作

            //2.1.根据名称查出转出账户
            Account sourceAccount = accountDao.getAccountByName(sourceName);
            //2.2.根据名称查出转入账户
            Account targetAccount = accountDao.getAccountByName(targetName);
            //2.3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney()-money);
            //2.4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney()+money);
            //2.5.更新转出账户
            accountDao.updateAccount(sourceAccount);

//            int a = 1/0;
            //2.6.更新转入账户
            accountDao.updateAccount(targetAccount);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //4.事务回滚
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //5.释放资源
            transactionManager.release();
        }
    }
}
