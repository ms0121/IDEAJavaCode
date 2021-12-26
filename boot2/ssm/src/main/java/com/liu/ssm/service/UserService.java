package com.liu.ssm.service;

import com.liu.ssm.domain.User;

import java.util.List;

/**
 * @author lms
 * @date 2021-11-05 - 10:49
 */
public interface UserService {
    public List<User> getUser();
    public void add(User user);
}
