package com.liu.boot.controller;

import com.liu.boot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.http.KeepAliveCache;

/**
 * @author lms
 * @date 2021-05-21 - 14:21
 */

@Controller
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/redis")
    @ResponseBody
    public String insert(){
        redisService.insert("key1", "value1");
        return "success";
    }

    // 通过路径参数的方式读取数据值
    @GetMapping("/get/{key}")
    @ResponseBody
    public String getKey(@PathVariable("key") String key){
        return redisService.getKey(key);
    }

    // 使用请求参数的方式进行读取redis中的字符串
    @GetMapping("get")
    @ResponseBody
    public String getValue(@RequestParam("key") String key){
        return redisService.getKey(key);
    }

}
