package com.mybatis;

import com.mybatis.dao.IUserDao;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author lenovo
 * @description: 测试Mybatis注解
 * @date 2020/8/19 13:16
 */
public class TestAnno {
    
        public static void main(String[] args) throws Exception{
            InputStream inputStream = Resources.getResourceAsStream("MybatisConfig.xml");
            SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            IUserDao userDao = sqlSession.getMapper(IUserDao.class);
            List<User> list = userDao.findAll();
            for (User user : list) {
                System.out.println(user.toString());
            }
        }
}
