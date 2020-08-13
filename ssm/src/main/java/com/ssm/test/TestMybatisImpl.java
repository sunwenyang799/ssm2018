package com.ssm.test;

import com.ssm.dao.IUserDao;
import com.ssm.dao.impl.IUserDaoImpl;
import com.ssm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @ Author     ：swy.
 * @ Date       ：Created in 22:02 2020/8/13
 * @ Description：测试dao有实现类如果实现
 */
public class TestMybatisImpl {
    public static void main(String[] args) throws  Exception{
        //  1.获取Mybatis全局配置
        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");
        //  2.创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //  3.使用工厂创建代理对象
        IUserDaoImpl userDao = new IUserDaoImpl(factory);
        //  4.使用代理对象调用方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
        //  5.释放资源
        inputStream.close();

        /*
        * 照比没有实现类使用工厂创建sqlsession对象是在实现类中实现的
        * */
    }
}
