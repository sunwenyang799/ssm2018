package com.spring.jdbcTemplate;

import com.mysql.jdbc.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author lenovo
 * @description:JdbcTemplate入门
 * @date 2020/8/24 14:00
 */
public class JdbcTemplateDemo1 {

     public static void main(String[] args){
         JdbcTemplate jdbcTemplate = new JdbcTemplate();
         DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/db_spring");
         dataSource.setUsername("root");
         dataSource.setPassword("admin");
         jdbcTemplate.setDataSource(dataSource);
         jdbcTemplate.execute("insert into t_account1(name,money) values('ccc',1000)");
     }
}
