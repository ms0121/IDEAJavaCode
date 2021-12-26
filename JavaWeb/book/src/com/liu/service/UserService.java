package com.liu.service;

import com.liu.pojo.User;

/**
 * @author lms
 * @date 2021-04-01 - 11:09
 * 具体对UserDao进行操作的接口类
 */

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 实现用户的登录
     * @return 返回值为user，说明用户存在，null用户不存在
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @return true说明用户存在，false说明不存在
     */
    public boolean existUsername(String username);
}



