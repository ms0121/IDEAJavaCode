package com.liu.boot.mapper;

import com.liu.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lms
 * @date 2021-05-19 - 9:15
 */

@Mapper
public interface UserMapper {
    User queryForUserById(Integer id);
}
