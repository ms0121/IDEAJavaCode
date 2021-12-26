package com.liu.dubbo.service.impl;

import com.liu.dubbo.model.User;
import com.liu.dubbo.service.SomeService;

/**
 * @author lms
 * @date 2021-05-23 - 15:12
 */
public class SomeServiceImpl implements SomeService {

    @Override
    public String hello() {
        return "hello world";
    }

    @Override
    public User queryUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("lisi" + id);
        return user;
    }
}
