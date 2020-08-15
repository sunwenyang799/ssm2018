package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @author lenovo
 * @version 1.0
 * @description: JDBC工具类
 * @date 2020/8/13 14:36
 */
public final class JDBCUtil {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    private static final String Driver = "com.mysql.jdbc.Driver";

    private static final String url = "jdbc:mysql://localhost:3306/db_gxyx";

    private  static final String username = "root";

    private static final String password = "admin";

    private static Connection connection  = null;

    private JDBCUtil(){

    }

    static {
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            logger.error("加载mysql驱动失败"+e);
        }
    }

    public Connection getConnection(){
        return connection;
    }
    /**
     * 查询数据
     * @param sql
     * */
    public static void retrieveData(String sql){

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                logger.info(resultSet.getString(1));
                logger.info(resultSet.getString(2));
                logger.info(resultSet.getString(3));
                logger.info(resultSet.getString(4));
                logger.info(resultSet.getString(5));
            }
        } catch (SQLException e) {
            logger.error("创建statement失败"+e);
        }
    }

    /**
     * 创建数据,修改数据,删除数据
     * @param sql
     */
    public static void updateData(String sql){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 为sql赋值
            preparedStatement.setString(1,"1111");
//            preparedStatement.setString(2,"22");
//            preparedStatement.setString(3,"33");
//            preparedStatement.setString(4,"44");
//            preparedStatement.setString(5,"11");
            preparedStatement.execute();
            logger.info("更新数据库成功");
        } catch (Exception e) {
            logger.error("创建statement失败"+e);
        }
    }




}
