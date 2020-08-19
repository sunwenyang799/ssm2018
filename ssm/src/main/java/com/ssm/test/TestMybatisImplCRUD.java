package com.ssm.test;

import com.ssm.dao.UserDao;
import com.ssm.dao.impl.UserDaoImpl;
import com.ssm.pojo.User;
import com.ssm.pojo.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:26 2020/8/15
 * @ Description：测试使用实现类实现mybatis的crud
 */
public class TestMybatisImplCRUD {

    private UserDao userDao;

    private InputStream inputStream;


    /**
     * 初始化获取代理对象
     */
    @Before
    public void init(){
        try {
            inputStream = Resources.getResourceAsStream("Mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        userDao = new UserDaoImpl(factory);
    }

    /**
     * 提交事务,释放资源
     */
    @After
    public void destory(){
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试查询所有
     * */
    @Test
    public void testFindAll()  {

        List<User1> list = userDao.findAll();
        for (User1 user : list) {
            System.out.println(user.toString());
        }
    }

    /**
     * 测试保存
     */
    @Test
    public void testSaveUser(){
        User1 user = new User1();
        user.setUsername("test impl insert1");
        user.setAdress("大连");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println("保存前的user:"+user.toString());
        userDao.saveUser(user);
        //  insert时用select_key查询last_insert_id可以获取到插入的id
        System.out.println("保存后的user:"+user.toString());

    }

    /**
     * 测试更新user
     */
    @Test
    public void testUpdateUser(){
        User1 user =new User1();
        user.setSex("女");
        user.setBirthday(new Date());
        user.setUsername("test impl update");
        user.setAdress("大连");
        user.setId(2);
        userDao.updateUser(user);
    }

    /**
     * 测试删除user
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(1);
    }

    /**
     * 测试根据id查询user
     */
    @Test
    public void testFindById(){
        User1 user = userDao.findById(2);
        System.out.println(user.toString());
    }

    /**
     * 测试根据username模糊查询
     */
    @Test
    public void testFindByUsername(){
        //  参数占位符方式
//        List<User1> list = userDao.findByUsername("%update%");
        //  字符串拼接sql方式
        List<User1> list = userDao.findByUsername("test");
        for (User1 user : list) {
            System.out.println(user.toString());
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

}
