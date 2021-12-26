package com.liu.thread.p2;

/**
 * @author lms
 * @date 2021-10-09 - 18:49
 * <p>
 * 验证volatile修饰变量的内存可见性
 */
public class VolatileTest2 {
    public static void main(String[] args) {
        volT volT = new volT();
        new Thread(new Runnable() {
            @Override
            public void run() {
                volT.say();
            }
        }).start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        volT.setFlag(false);

    }

    static class volT {
        // 无法解决内存可见性问题
        // private boolean flag = true;

        // 保证变量的可见性
        private volatile boolean flag = true;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void say() {
            System.out.println("开始执行..................");
            while (flag) {
                System.out.println("正在执行........");
            }
            System.out.println("结束执行..................");
        }
    }
}


