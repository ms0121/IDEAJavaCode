package com.liu.thread.p2;

/**
 * @author lms
 * @date 2021-10-09 - 19:34
 */
public class SynchronizedTest {
    public static void main(String[] args) {

        sysCla sysCla = new sysCla();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sysCla.say();
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sysCla.setFlag(false);
    }

    static class sysCla {
        private boolean flag = true;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public synchronized void say() {
            System.out.println("start ......................");
            while (flag) {
            }
            System.out.println("end ......................");
        }
    }
}
