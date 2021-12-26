package com.atguigu.aclservice.service.impl;

import com.atguigu.aclservice.entity.User;
import com.atguigu.aclservice.service.PermissionService;
import com.atguigu.aclservice.service.UserService;
import com.liu.security.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-05 - 17:58
 */
@Service("userDetailsService")
public class userDetailsServiceImpl implements UserDetailsService {

    // 需要查询数据库和对应的用户权限
    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        User user = userService.selectByUsername(username);
        // 判断用户是否存在
        if (user == null){
            throw new UsernameNotFoundException("用户不存在!");
        }

        // 将查询得到的user属性值复制到security中的User对象中
        com.liu.security.entity.User curUser = new com.liu.security.entity.User();
        BeanUtils.copyProperties(user, curUser);

        // 根据用户id查询用户的权限列表
        List<String> permissionValueList = permissionService.selectPermissionValueByUserId(user.getId());
        // 将查询得到的用户权限设置给用户
        SecurityUser securityUser = new SecurityUser();
        securityUser.setCurrentUserInfo(curUser);
        securityUser.setPermissionValueList(permissionValueList);
        return securityUser;
    }
}
