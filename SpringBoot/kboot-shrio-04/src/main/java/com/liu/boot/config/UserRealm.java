package com.liu.boot.config;

import com.liu.boot.pojo.User;
import com.liu.boot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lms
 * @date 2021-05-14 - 11:42
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了 ===> 授权了 doGetAuthorizationInfo");
        // 给用户授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 给所有登录后的用户添加授权，所以必须重新设置
        // info.addStringPermission("user:add");

        //获取当前登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        // 获取认证的用户信息
        User currentUser = (User) subject.getPrincipal();
        System.out.println("currentUser.getPerms() = " + currentUser.getPerms());
        // 设置当前用户的权限为： currentUser.getPerms()
        info.addStringPermission(currentUser.getPerms());

        return info;
    }


    // 用户登录验证（认证）
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("执行了 ===> 验 证了 doGetAuthenticationInfo");
        // 实现用户登录的验证
        // 用户名，密码，都从数据中进行获取
        // String name = "root";
        // String password = "123";

        // 获取封装了用户的信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 从数据库中查询用户的信息
        User user = userService.selectUserByName(userToken.getUsername());

        System.out.println("user = " + user);

        // 用户不存在，直接抛出异常的信息
        if (user == null){
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser", user);

        // 进行密码的验证信息, 并将当前user用户传到授权的页面
        return new SimpleAuthenticationInfo(user, user.getPwd(),"");
    }
}
