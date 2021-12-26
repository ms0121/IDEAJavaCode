package com.liu.boot.mapper;

import com.liu.boot.pojo.User;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author lms
 * @date 2021-05-12 - 20:39
 * @Mapper:表示当前的mapper是User的mapper类，即以前的mapper（dao）接口类
 */

@Mapper
@Repository
public interface UserMapper {

    List<User> queryMapper();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
