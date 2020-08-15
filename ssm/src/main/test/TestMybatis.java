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
 * @author lenovo
 * @version 1.0
 * @description: TODO
 * @date 2020/8/13 17:28
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
        SqlSessionFactory factory = factoryBuilder.build(resourceAsStream);
        //  3.使用工厂产生sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //  4.使用sqlSession创建代理对象
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
