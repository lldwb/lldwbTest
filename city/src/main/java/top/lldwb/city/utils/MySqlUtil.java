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
    private final static String URL = "jdbc:mysql://mysql.lldwb.top:33366/city?serverTimezone=Asia/Shanghai&useSSL=false";
    //  private   final static String URL = "jdbc:mysql://172.16.1.55:3306/city?serverTimezone=Asia/Shanghai&useSSL=false";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "@dwb123456";
    private Connection connection;
    private SqlExecutor sqlExecutor;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MySqlUtil() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            sqlExecutor = new SqlExecutor(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> select(String sql, T t, Object... objects) {
        BeanListHandler<T> beanListHandler = (BeanListHandler<T>) new BeanListHandler<>(t.getClass());
        return sqlExecutor.executeQuery(sql, beanListHandler, objects);
    }

    public void update(String sql, Object... objects) {
        sqlExecutor.executeUpdate(sql, objects);
    }
}
