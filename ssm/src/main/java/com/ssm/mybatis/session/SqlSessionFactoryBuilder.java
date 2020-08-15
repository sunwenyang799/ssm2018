package com.ssm.mybatis.session;

import com.ssm.mybatis.session.defaults.SqlSessionFactoryImpl;
import com.ssm.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author lenovo
 * @description:用于创建一个SqlSessionFactory工厂
 * @date 2020/8/14 15:34
 */
public class SqlSessionFactoryBuilder {

    public static SqlSessionFactory build(InputStream inputStream){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);
        return new SqlSessionFactoryImpl(configuration);
    }
}
