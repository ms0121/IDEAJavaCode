package com.liu.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.security.entity.SecurityUser;
import com.liu.security.entity.User;
import com.liu.security.security.TokenManager;
import com.liu.utils.utils.R;
import com.liu.utils.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-10-04 - 20:05
 * 认证过滤器
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    // 用户登录拦截器需要用到生成的token，redis模板，以及权限管理的工具
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    // 权限管理工具
    private AuthenticationManager authenticationManager;

    public TokenLoginFilter(TokenManager tokenManager, RedisTemplate redisTemplate, AuthenticationManager authenticationManager) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        // 设置提交方式
        this.setPostOnly(false);
        // 设置登录路径，并且是一个post提交方式
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/admin/acl/login","post"));
    }

    // 通过该方法可以获取到表单提交过来的用户名和密码
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 获取表单提交过来的数据信息
        try {
            // 将表单中的数据信息封装在User对象中
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            // UsernamePasswordAuthenticationToken(用户名，用户密码，操作权限)
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // 用户登录认证成功调用的方法
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // 认证成功，从authResult中获取用户信息
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        // 根据用户名生成token信息
        String token = tokenManager.create(user.getCurrentUserInfo().getUsername());
        // 将用户名和用户权限列表放到redis中
        redisTemplate.opsForValue().set(user.getCurrentUserInfo().getUsername(), user.getPermissionValueList());
        // 将token返回给浏览器，并设置在header中
        ResponseUtil.out(response, R.ok().data("token",token));
    }

    // 用户登录认证失败调用的方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ResponseUtil.out(response, R.error());
    }
}
