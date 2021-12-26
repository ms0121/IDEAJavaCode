package com.liu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lms
 * @date 2021-10-02 - 21:38
 * 方式2：实现用户名和密码的自定义设置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        // 设置用户名和密码以及该用户对应的权限
        auth.inMemoryAuthentication().withUser("lisi").password(password).roles("admin");

    }

    // 设置密码使用的加密方法
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
