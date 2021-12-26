package com.liu.security.security;

import com.liu.utils.utils.R;
import com.liu.utils.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-10-04 - 19:27
 * 退出处理器
 */
@Component
public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    // 构造器
    public TokenLogoutHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    // 退出操作
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 从header中获取指定的token信息
        String token = request.getHeader("token");
        // 如果token不为空，则从redis中进行移除token
        if (token != null){
            // 移除（其实直接不传递token就可以）
            tokenManager.removeToken(token);
            // 从token中获取用户的信息
            String username = tokenManager.getUserInfo(token);
            // 从redis中删除username
            redisTemplate.delete(username);
        }
        ResponseUtil.out(response, R.ok());
    }
}
