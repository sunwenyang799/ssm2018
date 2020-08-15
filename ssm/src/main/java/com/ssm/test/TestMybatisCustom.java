package com.ssm.test;

import com.ssm.dao.IUserDao;
import com.ssm.mybatis.io.Resources;
import com.ssm.mybatis.session.SqlSession;
import com.ssm.mybatis.session.SqlSessionFactory;
import com.ssm.mybatis.session.SqlSessionFactoryBuilder;
import com.ssm.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lenovo
 * @description: 测试自定义Mybatis
 * @date 2020/8/14 15:42
 */
public class TestMybatisCustom {

    public static void main(String[] args){

        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");

        SqlSessionFactory factory = SqlSessionFactoryBuilder.build(inputStream);

        SqlSession session = factory.openSession();

        IUserDao dao = session.getMapper(IUserDao.class);

        List<User> list = dao.findAll();

        for (User user : list) {
            System.out.println(user.toString());
        }

        session.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
