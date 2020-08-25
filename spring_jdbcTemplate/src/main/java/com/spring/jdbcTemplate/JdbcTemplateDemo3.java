package com.spring.jdbcTemplate;

import com.spring.pojo.Account;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 * @description:JdbcTemplate的单表CRUD
 * @date 2020/8/24 14:00
 */
public class JdbcTemplateDemo3 {

     public static void main(String[] args){
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
         JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
         //增加
//         jdbcTemplate.update("insert  into t_account1(name,money)values(?,?)","eee",1000);
         //更新
//         jdbcTemplate.update("update t_account1 set name  = ?,money = ? where id =?","eeee1",2000,8);
         //删除
//         jdbcTemplate.update("delete from t_account1 where id = ?",8);
         //查询所有
//         List<Account> list = jdbcTemplate.query("select * from t_account1", new BeanPropertyRowMapper<Account>(Account.class));

//         List<Account> list = jdbcTemplate.query("select * from t_account1", new AccountRowMapper());

//         List<Account> list = jdbcTemplate.query("select * from t_account1 where money >500", new BeanPropertyRowMapper<Account>(Account.class));

         //查询一个
//         List<Account> list = jdbcTemplate.query("select * from t_account1 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
//         for (Account account : list) {
//             System.out.println(account);
//         }
         //查询返回一行一列(使用聚合函数的)
         Integer integer = jdbcTemplate.queryForObject("select count(*) from t_account1", Integer.class);
         System.out.println(integer);

     }
}
class AccountRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setMoney(rs.getDouble("money"));
        account.setName(rs.getString("name"));
        return account;
    }
}
