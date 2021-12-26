package com.liu.shrio.config;

import com.liu.shrio.realm.MyRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-28 - 17:40
 *
 * @Configuration:标记当前类是一个spring的配置类，用于模拟spring的xml配置文件
 * 在这里需要配置使用shrio的属性设置
 *
 */

@Configuration
public class ShrioConfig {

    // 向容器中注入SecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置一个Realm，这个realm是最终用于完成我们的认证号和授权操作的具体对象
        securityManager.setRealm(realm);
        return securityManager;
    }

    // // 设置一个Realm，这个realm是最终用于完成我们的认证号和授权操作的具体对象
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    // 配置一个shrio的过滤器bean，这个bean将配置shrio相关规则的拦截规则，
    // 例如什么样的请求可以访问，什么样的拦截不可以访问
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        // 创建shiro拦截的拦截器， 用于拦截我们的用户请求
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置shiro的安全管理，设置管理的同时也会将指定某个bean用来完成我们权限的分配
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 用于设置一个登录的请求地址，这个地址可以是一个html或者是jsp的访问路径，也可以是一个
        // 控制器的路径
        // 作用是用于通知shiro我们可以使用这个路径转想我们的登录界面，但是shiro判断到我们
        // 当前的用户在没有登录的时候会自动的跳转到当前的这个路径下
        shiroFilterFactoryBean.setLoginUrl("/");

        /**
         * 登陆成功之后转向的页面，用于用户登陆后期需要交给shiro完成，因此就需要通知shiro登录
         * 成功之后返回到那个位置
         */
        shiroFilterFactoryBean.setSuccessUrl("/success");

        /**
         * 用于指定没有权限的页面，当用户访问某个功能，如果shiro判断这个用户
         * 没有对应的登陆操作，那么shiro就会将请求转向到当前的这个位置，
         * 用于提示用户没有操作权限
         */
        shiroFilterFactoryBean.setUnauthorizedUrl("/noPermission");

        /**
         * 定义一个Map集合，这个Map集合中存放的数据全部都是规则，用于设置通知Shiro
         * 什么样的请求可以访问什么样的请求不可以访问
         */
        Map<String, String> map = new LinkedHashMap<>();

        //  /login 表示某个请求的名字    anon 表示可以使用游客什么进行登录（这个请求不需要登录）
        map.put("/login", "anon");

        /**
         * //我们可以在这里配置所有的权限规则这列数据真正是需要从数据库中读取出来
         * 或者在控制器中添加Shiro的注解
         *  /admin/**  表示一个请求名字的通配， 以admin开头的任意子孙路径下的所有请求
         *  authc 表示这个请求需要进行认证（登录），只有认证（登录）通过才能访问
         *  注意： ** 表示任意子孙路径
         *  *  表示任意的一个路径
         *  ? 表示 任意的一个字符
         */
        map.put("/admin/**", "authc");
        map.put("/user/**", "authc");

        //表示所有的请求路径全部都需要被拦截登录，这个必须必须写在Map集合的最后面,这个选项是可选的
        map.put("/**","authc");
        // 把需要拦截的设置添加到拦截器中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}
