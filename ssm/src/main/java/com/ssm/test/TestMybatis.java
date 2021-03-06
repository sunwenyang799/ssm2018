package com.ssm.test;

import com.ssm.dao.IUserDao;
import com.ssm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ Author     ：swy.
 * @ Date       ：Created in 21:22 2020/8/13
 * @ Description：
 */
public class TestMybatis {

    public static void main(String[] args){
        //  1.读取配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  2.创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //  创建工厂使用构造者模式：把对象的创建细节隐藏，使用者直接调用方法即可创建对象
        SqlSessionFactory factory = factoryBuilder.build(resourceAsStream);
        //  3.使用工厂产生sqlSession对象
        //  创建sqlSession使用了工厂模式  优势：解耦（降低类之间的依赖关系）
        SqlSession sqlSession = factory.openSession();
        //  4.使用sqlSession创建代理对象
        //  创建代理对象使用了代理模式   不修改源码的基础上对已有方法的增强
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //  5.使用代理对象执行方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
        //  6.释放资源
        sqlSession.close();
        try {
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
