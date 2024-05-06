package task1.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.config
 * @author: ZGY
 * @createTime: 2024-03-23  03:09
 * @version: 1.0
 */
// dbConnect 数据库连接
public class DbConfig {
    private  final String URL = "jdbc:mysql://localhost:3306/data?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private  final String driver = "com.mysql.cj.jdbc.diver";
    private  final String USERNAME = "root";
    private  final String PASSWORD = "600600";

     // 方法的返回值
    public  Connection getConnection() throws SQLException, ClassNotFoundException {

        // 加载驱动
       Class.forName("com.mysql.cj.jdbc.Driver");
        //   conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        return  DriverManager.getConnection(URL,USERNAME,PASSWORD); // 连接
    }
}