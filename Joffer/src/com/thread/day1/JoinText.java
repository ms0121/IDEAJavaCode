package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-01 - 23:11
 * 模拟线程使用join方法
 *
 * join():
 *      1.join合并线程，待此线程执行完成之后，再执行其他的线程，再次期间，其他线程会阻塞
 *      2.可以把join想象成为插队的情形
 */
public class JoinText implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip线程来了 --- " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinText joinText = new JoinText();
        Thread thread = new Thread(joinText);
        thread.start();

        // 主线程
        for (int i = 0; i < 50; i++) {
            if (i == 25){
                // 表示当前主线程执行到25轮是，vip线程插队了，此时其他线程要等到
                // vip线程执行完毕之后，才可以执行下面的线程
                thread.join();
            }
            System.out.println("main主线程 ===== " + i);
        }
    }
}
