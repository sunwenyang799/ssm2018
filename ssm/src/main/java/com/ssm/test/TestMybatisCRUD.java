package com.ssm.test;

import com.ssm.dao.IUserDao;
import com.ssm.pojo.QueryVo;
import com.ssm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:26 2020/8/15
 * @ Description：测试mybatis的crud
 */
public class TestMybatisCRUD {

    private IUserDao userDao;

    private InputStream inputStream;

    private SqlSession session;

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
        session = factory.openSession(true);
        userDao = session.getMapper(IUserDao.class);
    }

    /**
     * 提交事务,释放资源
     */
    @After
    public void destory(){
//        session.commit();
        session.close();
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

        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user.toString());
        }

    }

    /**
     * 测试保存
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUserName("test autoCommit");
        user.setUserSex("男");
        user.setUserAdress("大连");
        user.setUserBirthday(new Date());
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
        User user =new User();
        user.setUserName("test updateUser");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        user.setUserAdress("updateUser");
        user.setUserId(4);
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
        User user = userDao.findById(6);
        System.out.println(user.toString());
    }

    /**
     * 测试根据username模糊查询
     */
    @Test
    public void testFindByUsername(){
        //  参数占位符方式
        List<User> list = userDao.findByUsername("%update%");
        //  字符串拼接sql方式
//        List<User> list = userDao.findByUsername("save");
        for (User user : list) {
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

    /**
     * 测试根据QueryVo中的username查询
     */
    @Test
    public void testFindByVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUserName("%User%");
        queryVo.setUser(user);
        List<User> list = userDao.findByVo(queryVo);
        for (User user1 : list) {
            System.out.println(user1.toString());
        }
    }

    /**
     * 测试根据user查询
     */
    @Test
    public void testFindUserByCondition(){
        User user = new User();
        user.setUserName("test impl update");
        user.setUserSex("男");
        List<User> list = userDao.findUserByCondition(user);
        for (User user1 : list) {
            System.out.println(user1.toString());
        }
    }

    /**
     * 测试in关键字
     */
    @Test
    public  void testFindUserInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(6);
        ids.add(777);
        vo.setIds(ids);
        List<User> list = userDao.findUserInIds(vo);
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
