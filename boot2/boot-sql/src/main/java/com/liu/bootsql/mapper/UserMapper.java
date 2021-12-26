package com.liu.bootsql.mapper;

import com.liu.bootsql.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lms
 * @date 2021-11-05 - 10:46
 */
@Mapper
public interface UserMapper {
    public User getUser(Integer id);
}
