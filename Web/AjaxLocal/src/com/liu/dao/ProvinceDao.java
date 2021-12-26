package com.liu.dao;

import com.liu.entity.Province;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.sql.*;

/**
 * @author lms
 * @date 2021-04-23 - 17:14
 */
public class ProvinceDao {

    // 通过id获取一个Province
    public Province queryProById(Integer id) {
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "";
        String name = "";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Province province = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            // 创建preparedstatement
            String sql = "select id, name, jiancheng, shenghui from province where id=?";
            ps = conn.prepareStatement(sql);
            // 设置参数值
            ps.setInt(1, id);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (ps != null){
                    ps.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return province;
    }


    // 通过id进行查找
    public String queryPrivinceById(Integer id) {
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "";
        String name = "";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            // 创建preparedstatement
            String sql = "select name from province where id=?";
            ps = conn.prepareStatement(sql);
            // 设置参数值
            ps.setInt(1, id);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                name = rs.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (ps != null){
                    ps.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
