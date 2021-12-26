package com.liu.juc.list;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lms
 * @date 2021-09-04 - 9:28
 * set的并发安全解决办法？
 * 1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
 * 2. Set<String> set = new CopyOnWriteArraySet<>();
 */
public class SetTest {
    public static void main(String[] args) {
        // hashset的底层是hashMap，此时的set是不安全的
//      Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // add的底层是hashMap的put方法
                set.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
