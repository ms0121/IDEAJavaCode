package com.liu.shrio.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * @author lms
 * @date 2021-05-28 - 17:43
 */

/**
 * 自定义的Realm用来实现用户的认证和授权
 * 父类 AuthorizingRealm 用于用户认证登录
 */
public class MyRealm extends AuthenticatingRealm {

    /**
     * 用于认证的方法，这个方法不能手动调用shiro，会自动进行调用
     * @param authenticationToken 用户身份令牌，整理存放着用户的账号和密码
     * @return 用户登录成功后的身份证明
     * @throws AuthenticationException 如果认证失败，Shiro会抛出各种异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 设置用户登录的规则,取出用户令牌中的用户信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        /**
         * 认证账号，从数据库中获取用户的详细信息
         * 如果进入id则代表出现了异常的信息
         */
        if (!"admin".equals(username) && !"zhangsan".equals(username)){
            throw new UnknownAccountException("账户不存在");
        }
        if ("zhangsan".equals(username)){
            throw new LockedAccountException("账户被锁定");
        }

        /**
         * 数据加密的意义就是防止数据在客户端和服务器之间传递的时候被篡改或窃取，
         * 因此应该在前台到后台的过程中进行加密，因此并不是在后台加密，应该在页面
         * 传递时进行加密
         */
        //String pwd = "123456";
        //密码加密码
        //参数 1 为加密算法 我们选择MD5加密
        //参数 2 为被加密的数据的数据
        //参数 3 为加密时的盐值 ，用于改变加密后数据结果
        //      通常这个盐值需要选择一个表中唯一的数据例如表中的账号
        //参数 4 为需要对数据使用指定的算法加密多少次
//		Object newPwd = new SimpleHash("MD5", password, "", 1);
//		System.out.println("newPwd = " + newPwd);
        // 给前端页面传过来的用户的密码进行加密（没有实际的意义）
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        credentialsMatcher.setHashIterations(1);
//        this.setCredentialsMatcher(credentialsMatcher);
//        System.out.println("来自于前端的password = " + password);

        /**
         * 创建密码认证对象，由Shiro自动认证密码
         * 参数1： 数据库中的账号
         * 参数2：数据库中的账号密码
         * 参数3: 为当前Realm的名字
         * 如果密码认证成功，则返回一个用户身份对象，如果密码认证失败，shiro会抛出异常
         */
        // 对数据库中的密码进行加密（真实的应当是保存在数据库中的数据是加密过的）

        return new SimpleAuthenticationInfo(username, "cebfa4dedd41487b9770f46f91f878a6", getName());
    }
}
