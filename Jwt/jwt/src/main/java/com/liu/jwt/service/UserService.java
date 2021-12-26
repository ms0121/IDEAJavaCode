package com.liu.jwt.service;

import com.liu.jwt.entity.User;

/**
 * @author lms
 * @date 2021-10-02 - 9:23
 */
public interface UserService {
    User login(User user);
}
