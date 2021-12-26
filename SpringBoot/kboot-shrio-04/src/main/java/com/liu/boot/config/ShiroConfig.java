package com.liu.boot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-14 - 11:42
 */
@Configuration
public class ShiroConfig {

    // 创建ShiroFilterFactoryBean的组件在容器中
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")
                                                                        DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 关联设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的内置过滤器（拦截访问的页面信息）
        /**
         * anon：无需认证就可以进行访问
         * authc：必须认证了才能进行访问
         * user：必须拥有 记住我 功能才能达到
         * perms: 拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        // 设置访问的权限
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 授权之后可以访问，设置拦截的权限，设置访问当前的页面需要权限，无权限不可以访问
        // 访问add页面必须被授权为: user:add, 必须授权之后才可以访问的页面
        filterMap.put("/user/add", "perms[user:add]");
//        filterMap.put("/user/update", "perms[user:update]");

        // 认证之后可以访问
        // filterMap.put("/user/add", "authc");
        // filterMap.put("/user/update", "authc");
        filterMap.put("/user/*", "authc");
        // 将设置的信息放入到bean中进行管理
        bean.setFilterChainDefinitionMap(filterMap);
        // 设置访问失败后跳转的页面
        bean.setLoginUrl("/toLogin");
        // 未授权的跳转页面信息
        bean.setUnauthorizedUrl("/unau");
        return bean;
    }


    // DefaultWebSecurityManager
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 安全管理器关联realm域的信息
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 创建realm对象，需要自定义类1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiro thymeleaf
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
