package com.liu.boot.mapper;

import com.liu.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lms
 * @date 2021-05-14 - 14:16
 */
@Repository // 将bean注入到容器中
@Mapper // mybatis根据这个注解找到接口的位置
public interface UserMapper {
    User selectByName(String name);
}
