package com.liu.juc.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lms
 * @date 2021-09-04 - 9:04
 * ArrayList在并发下是线程不安全的，如果使用synchronized同步方法，会使得
 * 效率降低，不推荐使用，因为vector底层就是使用的synchronized同步方法
 */
public class ListTest {
    public static void main(String[] args) {
        /**
         * 解决并发操作下List不安全的方法？
         * 1.List<String> list = new Vector<>();  效率低
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         *
         * CopyOnWrite 写时复制，cow计算机程序设计领域的一种优化策略
         * 多个线程调用的时候，list读取的时候是固定的，写入覆盖
         * 读写分离
         *
         * CopyOnWriteArrayList 比 Vector 好在哪里？
         * vector底层就是使用的synchronized同步方法解决线程安全问题，而
         * CopyOnWriteArrayList使用的是Lock锁进行加锁和解锁的操作
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println("list = " + list);
            }, String.valueOf(i)).start();
        }
    }
}
