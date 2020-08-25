package com.spring.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author lenovo
 * @description:使用ioc注入JdbcTemplate
 * @date 2020/8/24 14:00
 */
public class JdbcTemplateDemo2 {

     public static void main(String[] args){
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
         JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
         jdbcTemplate.execute("insert into t_account1(name,money) values('ddd',1000)");
     }
}
