package com.liu.bootsql.service.impl;

import com.liu.bootsql.domain.User;
import com.liu.bootsql.mapper.UserMapper;
import com.liu.bootsql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-11-05 - 10:49
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
