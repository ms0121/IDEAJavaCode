package com.liu.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-09-06 - 16:34
 */
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
    }
}
