package com.xxxx.crm3.interceptors;

import com.xxxx.crm3.exceptions.NoLoginException;
import com.xxxx.crm3.service.UserService;
import com.xxxx.crm3.utils.LoginUserUtil;
import com.xxxx.crm3.utils.UserIDBase64;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-10-10 - 15:17
 *  判断用户是否是登录状态
 *      获取Cookie对象，解析用户ID的值
 *          如果用户ID不为空，且在数据库中存在对应的用户记录，表示请求合法
 *          否则，请求不合法，进行拦截，重定向到登录页面
 */
// 非法请求拦截器设置，还需要配置才能让该拦截器生效，以前要在springmvc.xml中进行拦截的路径
public class NoLoginInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从session中查询用户的id信息
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 判断用户id是否存在或者该id对应的用户信息是否存在，不存在直接抛出异常信息
        if (userId == null || userService.selectByPrimaryKey(userId) == null){
            throw new NoLoginException();
        }
        return true;
    }
}
