package com.liu.boot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lms
 * @date 2021-05-13 - 10:45
 */
@EnableWebSecurity   // 开启安全注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 1. 重写HTTP安全的认证, 链式编程(授权http安全策略)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置访问页面的权限
        // 设置首页所有人可以访问，功能页只有对应请求的人才能访问
        // 添加认证请求,
        http.authorizeRequests().antMatchers("/").permitAll() //所有人可以访问首页
                .antMatchers("/level1/**").hasRole("vip1") // vip1可以访问level1
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认会跳转到登录页面，需要开启登录的页面,定制首页
        http.formLogin().loginPage("/toLogin");
        http.csrf().disable();//关闭csrf,不能get请求logout
        http.formLogin().usernameParameter("username").passwordParameter("password");//设置表单的username和password,方便自定义
        http.rememberMe();

        // 开启注销功能,然后跳转到首页
        http.logout().logoutSuccessUrl("/");

//       开启记住我的功能,设置参数接收的参数名
        http.rememberMe().rememberMeParameter("remember");
    }


    /**
     // 2. 定制认证规则
     * spring5中要求对密码进行加密处理
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据正常应该是从数据库中进行读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lms").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }

}
