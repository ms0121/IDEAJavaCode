package com.liu.security.filter;

import com.liu.security.security.TokenManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-05 - 16:27
 * 登录过滤器，就是在请求到达服务器之前先会经过拦截器处理（忘了就回去看Filter过滤器）
 * 授权过滤器
 */
public class TokenAuthFilter extends BasicAuthenticationFilter {
    // 再次发起请求的时候，需要从cookie的header中获取到token信息，从而拿到登录的用户名
    private TokenManager tokenManager;
    // 再从redis中获取对应的用户的权限列表
    private RedisTemplate redisTemplate;

    public TokenAuthFilter(AuthenticationManager authenticationManager, TokenManager tokenManager, RedisTemplate redisTemplate) {
        super(authenticationManager);
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    // 进行请求的拦截
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取当前认证成功的用户权限列表
        UsernamePasswordAuthenticationToken authRequest = getAuthentication(request);
        // 判断如果存在权限信息，则将权限放到上下文中
        if (authRequest != null){
            SecurityContextHolder.getContext().setAuthentication(authRequest);
        }
        // 如果权限确定成功，则放行操作
        chain.doFilter(request, response);
    }

    // 获取当前认证成功的用户权限列表
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // 从header中获取token信息
        String token = request.getHeader("token");
        if (token != null){
            // 从token中获取用户名
            String username = tokenManager.getUserInfo(token);
            // 从redis中查找对应用户的权限列表
            List<String> permissionValueList = (List<String>) redisTemplate.opsForValue().get(username);
            // 并强制转为Collection的形式
            Collection<GrantedAuthority> authority = new ArrayList<>();
            for (String s : permissionValueList) {
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(s);
                authority.add(auth);
            }
            return new UsernamePasswordAuthenticationToken(username, token,authority);
        }
        return null;
    }
}
