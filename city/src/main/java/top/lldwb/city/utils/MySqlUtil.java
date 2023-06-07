package top.lldwb.city.utils;

import org.nf.db.util.SqlExecutor;
import org.nf.db.util.result.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class MySqlUtil {
    final static String URL = "jdbc:mysql://mysql.lldwb.top:33366/city?serverTimezone=Asia/Shanghai&useSSL=false";
    final static String USER_NAME = "root";
    final static String PASSWORD = "@dwb123456";
    static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MySqlUtil() throws SQLException {
    }

    public static <T> List<T> select(String sql, T t, Object... objects) {
        SqlExecutor sqlExecutor = new SqlExecutor(connection);
        BeanListHandler<T> beanListHandler = (BeanListHandler<T>) new BeanListHandler<>(t.getClass());
        return sqlExecutor.executeQuery(sql, beanListHandler, objects);
    }
}
