package com.liu.boot.service;

import com.liu.boot.bean.User;
import com.liu.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-05-19 - 9:16
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User queryForUserById(Integer id) {
        return userMapper.queryForUserById(id);
    }

}
