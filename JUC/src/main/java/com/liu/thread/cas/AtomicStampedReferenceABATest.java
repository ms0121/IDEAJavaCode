package com.liu.thread.cas;

import sun.util.locale.provider.TimeZoneNameUtility;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author lms
 * @date 2021-10-10 - 9:51
 * 为什么AtomicStampedReference可以避免ABA问题？
 *      因为AtomicStampedReference元子类中有一个整数标记值为stamp，每次执行cas操作的时候，
 *      都需要对比它的版本，即比较stamp中的值
 */
public class AtomicStampedReferenceABATest {
    // 在创建AtomicStampedReference变量的时候，引用"abc"字符串，并设置相应的版本号
    public static AtomicStampedReference<String> asr = new AtomicStampedReference<>("abc", 0);

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            // 每次对其进行更改的时候，都要进行版本号的验证以及更改（asr.getStamp(期望的版本号)）
            asr.compareAndSet("abc", "def", asr.getStamp(), asr.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + " ===> " + asr.getReference());
            // 这次的asr.getStamp()是上一个操作更新后的版本号
            asr.compareAndSet("def", "abc", asr.getStamp(), asr.getStamp() + 1);
        });

        Thread thread1 = new Thread(() -> {
            // 更新之前获取版本号(可以解决ABA问题)，因为在休眠的过程中，可能发生了线程修改的操作，
            int stamp = asr.getStamp();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 更新之后获取版本号(无法解决ABA问题)
            // int stamp = asr.getStamp();
            asr.compareAndSet("abc", "dsjhj", stamp, stamp + 1);
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println("asr.getReference() = " + asr.getReference());
    }
}
