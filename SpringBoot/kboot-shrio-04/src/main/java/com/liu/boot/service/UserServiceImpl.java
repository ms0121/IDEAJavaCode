package com.liu.boot.service;

import com.liu.boot.mapper.UserMapper;
import com.liu.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-14 - 14:23
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByName(String username) {
        User user = userMapper.selectByName(username);
        return user;
    }

}
