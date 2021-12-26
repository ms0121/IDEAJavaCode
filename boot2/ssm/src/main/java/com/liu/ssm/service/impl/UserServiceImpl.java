package com.liu.ssm.service.impl;


import com.liu.ssm.domain.User;
import com.liu.ssm.mapper.UserMapper;
import com.liu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lms
 * @date 2021-11-05 - 10:49
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void add(User user) {
        userMapper.add(user);
        int a = 1 / 0;
    }
}
