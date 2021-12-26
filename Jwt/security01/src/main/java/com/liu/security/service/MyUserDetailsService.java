package com.liu.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.security.entity.Users;
import com.liu.security.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-02 - 22:01
 * 给当前的类创建的bean对象设置名字为 userDetailsService
 */
//@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    //     方式3
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        // 给用户设置权限
//        List<GrantedAuthority> role = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
//        // 设置用户名，密码以及角色权限
//        return new User("zhangsan", new BCryptPasswordEncoder().encode("123"), role);
//    }

    @Resource
    private UserMapper userMapper;

    // 从数据库中进行查询数据信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 构建查询条件
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        // 查询数据库记录
        Users users = userMapper.selectOne(wrapper);

        System.out.println("users = " + users);

        if (users == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }

        // 当前用户名的用户存在
        // 给用户设置权限
        List<GrantedAuthority> role = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        // 设置用户名，密码以及角色权限
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()), role);
    }

}
