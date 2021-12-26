package com.liu.security.config;

import com.liu.security.filter.TokenAuthFilter;
import com.liu.security.filter.TokenLoginFilter;
import com.liu.security.security.DefaultPasswordEncoder;
import com.liu.security.security.TokenLogoutHandler;
import com.liu.security.security.TokenManager;
import com.liu.security.security.UnauthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author lms
 * @date 2021-10-05 - 17:12
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private DefaultPasswordEncoder defaultPasswordEncoder;
    private UserDetailsService userDetailsService;

    @Autowired
    public TokenWebSecurityConfig(TokenManager tokenManager, RedisTemplate redisTemplate, DefaultPasswordEncoder defaultPasswordEncoder, UserDetailsService userDetailsService) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.defaultPasswordEncoder = defaultPasswordEncoder;
        this.userDetailsService = userDetailsService;
    }


    /**
     * 设置配置
     * 设置退出的地址和token，以及redis中的操作
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                // 当前用户没有权限访问的时候调用指定的类中的方法
                .authenticationEntryPoint(new UnauthEntryPoint())
                // 关闭csrf防护的功能
                .and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                // 设置退出的路径
                .and().logout().logoutUrl("/admin/acl/index/logout")
                // 使用下面退出操作的处理逻辑
                .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate)).and()
                // 添加自定义的过滤器
                // 认证过滤器
                .addFilter(new TokenLoginFilter(tokenManager, redisTemplate, authenticationManager()))
                // 授权过滤器
                .addFilter(new TokenAuthFilter(authenticationManager(), tokenManager, redisTemplate)).httpBasic();
    }


    // 调用userDetailsService和默认的密码处理方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }

    // 设置不需要认证就可以直接访问的路径
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/**");
    }
}













