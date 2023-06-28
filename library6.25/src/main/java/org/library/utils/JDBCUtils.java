package org.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
//⼯具类包，通⽤的且与项⽬业务⽆关的类的组合。
/** JDBC工具类 */
public class JDBCUtils {
    /** 定义数据库驱动程序(MySQL) */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /** 定义数据库连接地址 */
    private static final String URL = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC&characterEncoding=utf-8";
    /** 定义数据库服务器登录用户名 */
    private static final String USERNAME = "root";
    /** 定义数据库登录密码 */
    private static final String PASSWORD = "225059";

    /*
     * 利用静态初始化块加载数据库驱动程序 静态初始化块在类加载时就调用,且只调用一次
     */
    static {
        try {
            // 加载数据库驱动程序
            Class.forName(DRIVER);
            System.out.println("数据库驱动程序加载成功！");
        } catch (Exception e) {
            System.out.println("数据库驱动程序加载失败：" + e.getMessage());
        }
    }

    /** 获取Connection对象的方法 */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 连接数据库，获取Connection对象
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("连接数据库成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败：" + e.getMessage());
        }
        return conn;
    }
}
