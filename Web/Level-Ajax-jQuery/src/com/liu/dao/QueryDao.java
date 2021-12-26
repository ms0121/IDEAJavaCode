package com.liu.dao;

import com.liu.entity.City;
import com.liu.entity.Province;
import com.sun.corba.se.impl.orbutil.CacheTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-24 - 20:47
 */
public class QueryDao {

    // 根据传入的id获得所有的城市
    public List<City> SelectCity(Integer pId){
        List<City> retList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select id, name, provinceId from city where provinceid = ? order by id";
            ps = conn.prepareStatement(sql);
            // 设置占位符
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                city.setProvinceId(rs.getString("provinceId"));
                retList.add(city);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return retList;
    }


    // 查询所有的省份
    public List<Province> selectProvince() {
        List<Province> retList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select id,name, jiancheng, shenghui from province order by id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Province province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
                retList.add(province);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return retList;
    }


    private void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null){
                conn.close();
            }
            if (ps != null){
                ps.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        QueryDao queryDao = new QueryDao();
//        List<Province> provinces = queryDao.selectProvince();
//        for (Province province : provinces) {
//            System.out.println(province);
//        }
        List<City> cities = queryDao.SelectCity(1);
        for (City city : cities) {
            System.out.println("city = " + city);
        }
    }
}
