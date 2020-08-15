package com.ssm.mybatis.session.defaults;

import com.ssm.mybatis.proxy.MapperProxy;
import com.ssm.mybatis.session.Configuration;
import com.ssm.mybatis.session.SqlSession;
import com.ssm.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author lenovo
 * @description: SqlSession实现类
 * @date 2020/8/14 17:27
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration configuration;

    private Connection connection;

    public SqlSessionImpl(Configuration configuration){
        this.configuration = configuration;
        connection = DataSourceUtil.getConnection(configuration);
    }
    /**
     * @param  daoInterfaceClass dao的接口字节码
     * 创建代理对象
     * */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
       return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},
                new MapperProxy(configuration.getMappers(),connection));
    }

    /**
     * 释放资源
     * */
    @Override
    public void close() {
        if(connection!=null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
