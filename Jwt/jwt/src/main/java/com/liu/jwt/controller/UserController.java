package com.liu.jwt.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.liu.jwt.entity.User;
import com.liu.jwt.service.UserService;
import com.liu.jwt.util.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-10-02 - 9:24
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public Map<String, Object> login(User user){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println("user.getUsername() = " + user.getUsername());
        System.out.println("user.getPassword() = " + user.getPassword());

        try {
            User userLogin = userService.login(user);
            // 用户存放负载信息,从而调用jwt生成相应的token信息
            HashMap<String, String> payload = new HashMap<>();
            payload.put("id", userLogin.getId());
            payload.put("username", userLogin.getUsername());

            // 生成token信息
            String token = JwtUtils.getToken(payload);

            map.put("code", "200");
            map.put("msg","登录成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("code", "500");
            map.put("msg", e.getMessage());
        }
        return map;
    }


    // 方式1：未使用拦截器，代码冗余
    // 登录之后执行相应的业务逻辑
//    @PostMapping("test")
    public Map<String, Object> verify(String token){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println("token = " + token);

        // 验证token
        try {
            JwtUtils.verify(token);
            // 获取token的返回值信息，类型为DecodedJWT
            DecodedJWT tokenInfo = JwtUtils.getTokenInfo(token);
            map.put("code", "200");
            map.put("msg","请求成功");
            return map;
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
        return map;
    }


    // 方式2：配置了拦截器（只有登录之后才能进行使用该方法）
    @PostMapping("test")
    public Map<String, Object> test(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        // 从请求头中获取token信息
        String token = request.getHeader("token");
        DecodedJWT tokenInfo = JwtUtils.getTokenInfo(token);

        // 处理自己的业务逻辑
        map.put("code", "200");
        map.put("msg","请求成功");

        String username = tokenInfo.getClaim("username").asString();
        String id = tokenInfo.getClaim("id").asString();
        map.put("username", username);
        map.put("id", id);

        return map;
    }




}
