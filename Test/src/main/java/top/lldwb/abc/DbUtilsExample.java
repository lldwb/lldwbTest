package top.lldwb.abc;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilsExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载JDBC驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

        // 创建QueryRunner对象
        QueryRunner qr = new QueryRunner();

        // 执行insert操作
        int result = qr.update(conn, "insert into user(name, age) values(?, ?)", "张三", 20);
        System.out.println("insert result: " + result);

        // 执行update操作
        result = qr.update(conn, "update user set age=? where name=?", 30, "张三");
        System.out.println("update result: " + result);

        // 执行delete操作
        result = qr.update(conn, "delete from user where name=?", "张三");
        System.out.println("delete result: " + result);

        // 关闭数据库连接
        conn.close();
    }
}
