package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 14:20 2020/8/22
 * @ Description：spring配置类(相当于bean.xml中的配置)
 *
 * Configuration:作用：指定当前类是一个配置类
 * ComponentScan：
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
 *                  使用此注解相当于xml配置中的
 *             <context:component-scan base-package="com.spring"></context:component-scan>
 *Bean
 *   作用:用于把当前方法的返回值作为bean对象存入到spring的ioc容器中
 *   属性：name：用于指定bean的id。当不写时，默认值为当前方法名
 *   细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中找有没有可用的bean。
 *       查找方式和Autowired一样
 *Import
 *  作用：导入其他类的配置(其他配置类不用加@Configuration注解也可)
 *  属性：value：用于指定其他配置类的字节码
 *              当我们使用Import注解时，有Import的注解就是父配置类，导入的是子配置类
 * PropertySource
 *    作用：用于指定读取properties的文件位置
 *    属性：value：指定文件的名称和路径
 *          关键字：classpath
 */
//@Configuration
@ComponentScan("com.spring")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
