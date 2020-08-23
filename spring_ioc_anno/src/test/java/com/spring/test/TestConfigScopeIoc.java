package com.spring.test;

import com.spring.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 14:45 2020/8/22
 * @ Description：测试通过配置文件创建对象的作用范围
 */
public class TestConfigScopeIoc {

    @Test
    public void testQueryRunner(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner = applicationContext.getBean("queryRunner", QueryRunner.class);
        QueryRunner queryRunner1 = applicationContext.getBean("queryRunner", QueryRunner.class);
        System.out.println(queryRunner == queryRunner1);
    }
}
