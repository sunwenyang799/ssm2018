package com.mybatis;

import com.mybatis.dao.IAccountDao;
import com.mybatis.dao.IUserDao;
import com.mybatis.pojo.Account;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lenovo
 * @description: 测试mybatis注解多表一对多查询
 * @date 2020/8/19 13:30
 */
public class TestAnnoCRUD_OneToMany {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public  void init() throws  Exception{
        inputStream  = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory(){
        sqlSession.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll(){
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getAccountList());
        }
    }
}
