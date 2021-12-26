package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.pojo.User;

/**
 * @author lms
 * @date 2021-04-01 - 10:27
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryForUsername(String username) {
        // 根据用户名查询用户的信息
        String sql = "select username, password, email from t_user where username=?";
        User user = queryForOne(User.class, sql, username);
        return user;
    }

    @Override
    public User queryForUsernameAndPassword(String username, String password) {
        // 根据用户名和密码进行查询用户的信息
        String sql = "select id, username, password, email from t_user where username=? and password=?";
        User user = queryForOne(User.class, sql, username, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        // 插入一条用户信息
        String sql = "insert into t_user(username, password, email)values(?,?,?)";
        int flag = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return flag;
    }
}


