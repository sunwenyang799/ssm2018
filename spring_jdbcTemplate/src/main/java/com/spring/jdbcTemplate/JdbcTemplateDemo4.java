package com.spring.jdbcTemplate;

import com.spring.dao.IAccountDao;
import com.spring.pojo.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lenovo
 * @description:JdbcTemplate在Dao中的使用
 * @date 2020/8/24 14:00
 */
public class JdbcTemplateDemo4 {

     public static void main(String[] args){
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
         IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
         Account account = accountDao.getAccountById(1);
         System.out.println(account);

         account.setMoney(3000.0);
         accountDao.updateAccount(account);
         System.out.println(account);
     }
}
