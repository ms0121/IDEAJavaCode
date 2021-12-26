package com.liu.boot.service;

/**
 * @author lms
 * @date 2021-05-21 - 14:14
 */

public interface RedisService {
    void insert(String key, String value);
    String getKey(String key);
}
