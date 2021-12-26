package com.liu.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.security.entity.Users;
import com.liu.security.mapper.UsersMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-03 - 0:00
 */
@Service("userDetailsService")
public class UsersDetailService implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        // 查询
        Users users = usersMapper.selectOne(wrapper);
        if (users == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }

        // 给用户设置权限
        List<GrantedAuthority> role = AuthorityUtils.commaSeparatedStringToAuthorityList("admin, ROLE_role");
        // 添加用户
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()), role);
    }
}
