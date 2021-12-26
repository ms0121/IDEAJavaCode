package com.liu.dubbo.service;

import com.liu.dubbo.model.User;

/**
 * @author lms
 * @date 2021-05-23 - 15:04
 */
public interface SomeService {

    String hello();
    User queryUserById(Integer id);

}
