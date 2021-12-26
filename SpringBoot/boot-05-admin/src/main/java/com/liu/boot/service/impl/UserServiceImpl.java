package com.liu.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.boot.bean.User;
import com.liu.boot.mapper.UserMapper;
import com.liu.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-19 - 10:29
 * ServiceImpl<UserMapper, User>:代表要操作的表，以及返回的数据类型
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
