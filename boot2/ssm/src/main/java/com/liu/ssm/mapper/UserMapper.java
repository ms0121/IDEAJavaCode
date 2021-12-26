package com.liu.ssm.mapper;


import com.liu.ssm.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lms
 * @date 2021-11-05 - 10:46
 */
@Mapper
public interface UserMapper {
    public List<User> getUser();

    public void add(User user);

}
