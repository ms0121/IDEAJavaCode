package com.liu.juc.list;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lms
 * @date 2021-09-04 - 9:38
 * Map也是不安全的，解决办法？
 * 1. Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
 * 2.  Map<String, Object> map = new ConcurrentHashMap<>()
 *
 * map是这样子使用的吗？
 *  不是，工作中不使用hashmap
 *  默认等价于什么？ new HashMap<>(16.0.75)
 *   研究concurrentMap的是底层原理是什么？
 */
public class MapTest {
    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
        // 并发下使用的map
        Map<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            new Thread( () -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            }).start();
        }
    }
}
