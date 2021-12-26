package com.liu.boot.service;

import com.liu.boot.pojo.User;

/**
 * @author lms
 * @date 2021-05-14 - 14:22
 */
public interface UserService {
    User selectUserByName(String username);
}
