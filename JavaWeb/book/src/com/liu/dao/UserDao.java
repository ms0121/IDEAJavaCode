package com.liu.dao;

import com.liu.pojo.User;

/**
 * @author lms
 * @date 2021-04-01 - 10:21
 * 定义对User类进行操作的接口
 */
public interface UserDao {
    // 根据用户名查询用户的信息
    public User queryForUsername(String username);

    // 根据用户名和用户密码进行查询用户的信息
    public User queryForUsernameAndPassword(String username, String password);

    // 保存用户的信息,并返回提示信息
    public int saveUser(User user);
}
