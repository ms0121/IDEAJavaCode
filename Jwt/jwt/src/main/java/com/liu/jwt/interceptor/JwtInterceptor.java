package com.liu.jwt.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.jwt.util.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author lms
 * @date 2021-10-02 - 10:21
 * jwt拦截器，执行token的验证工作（集的配置拦截器）
 */
public class JwtInterceptor implements HandlerInterceptor {

    /**
     * 在目标方法执行之前执行
     * @param request
     * @param response
     * @param handler 目标方法
     * @return true，代表放行， false，表示禁止放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        // 因为token存放在请求头中，
        String token = request.getHeader("token");

        // 验证token
        try {
            // 直接验证token是否正确，如果token不正确，会直接抛出异常信息被全局异常捕获
            JwtUtils.verify(token);
            // 验证通过，直接放行请求
            return true;

        } catch (SignatureVerificationException e){
            map.put("msg", "无效签名");
        } catch (TokenExpiredException e){
            map.put("msg", "token已过期");
        } catch (AlgorithmMismatchException e){
            map.put("msg", "token算法不一致");
        } catch (Exception e) {
            map.put("msg", "token无效");
        }
        map.put("code", "500");
        // 将map转为json数据信息
        // 因为response底层也封装了json，也可以使用fastJson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
        // 禁止放行请求
        return false;
    }
}
