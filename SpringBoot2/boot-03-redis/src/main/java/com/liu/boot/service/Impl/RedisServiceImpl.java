package com.liu.boot.service.Impl;

import com.liu.boot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-21 - 14:15
 */

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void insert(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getKey(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
