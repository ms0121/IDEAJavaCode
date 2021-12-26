package com.liu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author lms
 * @date 2021-10-02 - 21:38
 * 方式2：实现用户名和密码的自定义设置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    // 实现记住我的功能
    @Resource
    private DataSource dataSource;

    // 实现记住我功能的表的创建
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        // 创建jdbc的实现类
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 设置使用的数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 设置启动的时候就自动的创建存放token的数据表
        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 将自定义的用户类进行注入到权限中
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * 自定义登录页面和显示登录成功之后的登录页面
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 配置退出登录的映射地址信息
        http.logout()
                .logoutUrl("/logout")  // 退出登录的请求
                // 退出之后的跳转的请求路径
                .logoutSuccessUrl("/test/index").permitAll();

        // 配置没有权限访问的跳转页面
        http.exceptionHandling().accessDeniedPage("/403.html");

        // 自定义登录页面和其他的设置信息
        http.formLogin()
                .loginPage("/login.html") // 自定义登录页面首页(首页需要放置在static中)
                .loginProcessingUrl("/user/login")  // 表单提交的请求地址

                //登录成功之后发起请求路径，并且登录之后可以访问所有的设置信息
                // .defaultSuccessUrl("/test/index").permitAll()

                // 配置登录成功之后跳转到的页面
                .defaultSuccessUrl("/success.html").permitAll()

                .and().authorizeRequests()
                // 表示下面的请求在未登录的情况下也可以直接访问的请求
                .antMatchers("/", "/test/hello","/test/login").permitAll()

                // 方式1：hasAuthority 表示只能有当前的角色权限才可以访问当前的路径信息
                // 设置只有admin权限的用户才可以访问当前的test/success请求路径信息
                // .antMatchers("/test/success").hasAuthority("admin")
                // 设置只有admin权限的用户才可以访问当前的test/role请求路径信息
                // .antMatchers("/test/role").hasAuthority("role")

                // 方式2：hasAnyAuthority，表示当前的用户只要拥有其中一个角色权限就可以访问
                // .antMatchers("/test/success").hasAnyAuthority("admin, role")

                // 方式3：hasRole()，底层会自动将role拼接成为: ROLE_role(所以前面需要给用户设置的角色为ROLE_role)
                // .antMatchers("/test/success").hasRole("role")
                .antMatchers("/test/success").hasRole("role")
                .anyRequest().authenticated()

                // 添加记住我功能,设置使用上面创建的数据表
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60) // 设置token的有效时长
                // 设置使用的具体的操作userDetailsService
                .userDetailsService(userDetailsService)
                .and().csrf().disable(); // 关闭csrf防护
    }
}
