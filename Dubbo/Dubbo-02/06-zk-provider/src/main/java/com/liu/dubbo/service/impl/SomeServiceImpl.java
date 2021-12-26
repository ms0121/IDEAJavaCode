package com.liu.dubbo.service.impl;

import com.liu.dubbo.model.User;
import com.liu.dubbo.service.SomeService;

/**
 * @author lms
 * @date 2021-05-23 - 16:55
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public String hello() {
        return "zookeeper + dubbo";
    }

    @Override
    public User queryUserById(Integer id) {
        User user = new User();
        user.setId(1001);
        user.setName("ilsi" + id);
        return user;
    }
}
