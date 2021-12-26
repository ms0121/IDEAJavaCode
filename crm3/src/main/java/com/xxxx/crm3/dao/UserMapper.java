package com.xxxx.crm3.dao;

import com.xxxx.crm3.base.BaseMapper;
import com.xxxx.crm3.vo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User, Integer> {

    // 根据用户名查询用户对象
    User queryUserByUserName(String userName);

    // 根据真名名称进行查询
    User queryUserByTrueName(String trueName);

    // 查询拥有销售角色的用户信息
    List<Map<String, Object>> queryAllSales();
}
