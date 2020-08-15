import utils.JDBCUtil;

/**
 * @author lenovo
 * @version 1.0
 * @description: jdbc复习  https://www.runoob.com/w3cnote/jdbc-use-guide.html菜鸟教程
 * @date 2020/8/13 14:35
 */
public class TestJDBC {

    public static void main(String[] args){

//        try {
//            // 加载驱动mysql驱动  ClassNotFoundException oracle驱动oracle.jdbc.driver.OracleDriver
//            Class.forName("com.mysql.jdbc.Driver");
//            //  获取连接  SQLException
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gxyx", "root", "admin");
//            //   操作数据库
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from t_class");
//            while(resultSet.next()){
//                //  通过表列查询
//                String string = resultSet.getString(1);
//                // 通过表字段名查询
//                String c_bjbh = resultSet.getString("c_bjbh");
//                System.out.println(string);
//                System.out.println(c_bjbh);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // 查询
//        JDBCUtil.retrieveData("select * from t_class");
//       添加
//        JDBCUtil.updateData("insert into t_class values(?,?,?,?,?)");
        //  修改
//        JDBCUtil.updateData("update  t_class set c_bjbh = ?,c_bjmc = ?,c_zybh = ?,c_xybh = ? where c_bjbh = ?");
        //  删除
        JDBCUtil.updateData("delete from t_class where c_bjbh = ?");
    }
}
