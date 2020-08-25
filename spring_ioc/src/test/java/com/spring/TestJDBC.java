package com.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author lenovo
 * @description: jdbc程序耦合和解耦分析
 * @date 2020/8/20 14:40
 * 程序的耦合：
 *         耦合：程序间的依赖关系
 *              包括：类之间的依赖
 *                    方法之间的依赖
 *          解耦：降低程序之间的依赖关系
 *          实际开发中：编译器不依赖，运行期依赖
 *          解耦思路：
 *              第一步：使用反射来创建对象，而避免使用new关键字
 *              第二步：通过读取配置文件来获取要创建对象的全限定类名
 *
 */
public class TestJDBC {
    
    public static void main(String[] args) throws Exception{
        //  注册驱动
        //  通过new关键字注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //  反射方式注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //  获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_spring", "root", "admin");
        //  获取预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user");
        //  获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //  遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }
        //  释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
