package com.tuling.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获取执行sql语句的对象
        Statement statement = conn.createStatement();
        //4.定义执行sql语句
        String sql = "insert into person(name, age, sex) values('zhoujielun', 33, 'F')";
        int row = statement.executeUpdate(sql);//执行完会返回受影响的行数
        //5.处理结果
        if (row >= 0){
            System.out.println("successfully execute!");
        }
        //6.释放资源
        statement.close();;
        conn.close();


    }
}
