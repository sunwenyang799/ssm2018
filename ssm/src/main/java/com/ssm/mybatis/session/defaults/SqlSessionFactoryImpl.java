package com.ssm.mybatis.session.defaults;

import com.ssm.mybatis.session.Configuration;
import com.ssm.mybatis.session.SqlSession;
import com.ssm.mybatis.session.SqlSessionFactory;

/**
 * @author lenovo
 * @description: SqlSessionFactory实现类
 * @date 2020/8/14 17:26
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration configuration;

    public SqlSessionFactoryImpl(Configuration configuration){
        this.configuration = configuration;
    }
    /**
     * 创建SqlSession对象
     * @return
     * */
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(configuration);
    }
}
