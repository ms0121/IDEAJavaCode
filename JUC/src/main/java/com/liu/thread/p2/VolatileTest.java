package com.liu.thread.p2;

/**
 * @author lms
 * @date 2021-10-09 - 16:59
 */
public class VolatileTest {
    public static void main(String[] args) {
        voCla voCla = new voCla();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    voCla.say();
                }
            }).start();
        }
    }

    static class voCla {
        boolean  num = false;

        public void say(){
            while (!num){
                System.out.println(Thread.currentThread().getName() + ", dhsjhdjshjds");
                num = true;
            }
            System.out.println("执行结束");
        }
    }
}

