package com.liu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lms
 * @date 2021-04-01 - 9:26
 */
public class JdbcUtils {

    // 创建数据库连接池对象
    private static DruidDataSource dataSource;
    // 创建ThreadLocal对象，进行保存connection对象，实现整个流程都能够使用同一个connection对象，从而实现数据库事务
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    // 使用静态代码块进行初始化数据库连接池
    static {
        Properties properties = new Properties();
        InputStream is = null;
        try {
            // 使用映射的方法进行获取当前类对象,从而获取流资源信息
            is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            // 成功创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    只要main方法执行, 就可以获取到连接信息
//    public static void main(String[] args) {
//        Connection connection = getConnection();
//        System.out.println("connection = " + connection);
//    }

    // 获取数据库连接池中的连接
    // 如果返回为null则获取失败，否则获取成功
    public static Connection getConnection() {
        Connection conn = null;
        if (conn == null){
            try {
                // 从数据库连接池中获取连接对象
                conn = dataSource.getConnection();
                // 将conn保存到ThreadLocal对象中，供后面的jdbc操作使用
                conns.set(conn);
                // 设置为手动管理事务
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        // 如果不等于null，说明之前使用过连接，操作过数据库
        if (connection != null){
            try {
                connection.commit();  // 提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();  // 关闭资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove的操作，否则就会出错，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }


    /**
     * 回滚事务，并关闭连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        // 如果不等于null，说明之前使用过连接，操作过数据库
        if (connection != null){
            try {
                connection.rollback();  // 回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();  // 关闭资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove的操作，否则就会出错，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }



//    // 关闭连接资源
//    public static void close(Connection conn) {
//        if (conn != null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
