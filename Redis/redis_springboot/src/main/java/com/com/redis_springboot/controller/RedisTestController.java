package com.com.redis_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-05-03 - 9:42
 */

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String name() {
        // 设置值到redis中
        redisTemplate.opsForValue().set("name","lucy");
        // 从redis中获取值
        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }
}
