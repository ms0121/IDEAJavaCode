package com.liu.jwt.service.impl;

import com.liu.jwt.dao.UserDao;
import com.liu.jwt.entity.User;
import com.liu.jwt.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-10-02 - 9:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
