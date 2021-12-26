package com.liu.jwt.dao;

import com.liu.jwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lms
 * @date 2021-10-02 - 9:22
 */
@Mapper
public interface UserDao {
    User login(User user);
}
