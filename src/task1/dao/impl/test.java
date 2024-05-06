package task1.dao.impl;

import java.sql.*;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.dao.impl
 * @author: ZGY
 * @createTime: 2024-03-28  14:59
 * @version: 1.0
 */

public class test {
    private static final String URL = "jdbc:mysql://localhost:3306/data?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String driver = "com.mysql.cj.jdbc.diver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "600600";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //   conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 连接

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from employee");

        while(resultSet.next()){
            String em = resultSet.getString("name");
            System.out.println(em);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}