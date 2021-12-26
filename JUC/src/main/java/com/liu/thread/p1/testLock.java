package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-10 - 11:06
 */
class SubThread2 extends Thread {
    public boolean flag=true;
    @Override
    public void run() {
        while (true){
            if (flag){
                System.out.println("flag为true,程序继续执行！");
            }else{
                System.out.println("flag为false,程序退出！！");
                return;
            }
        }
    }
}
public class testLock {
    public static void main(String[] args) throws InterruptedException {
        SubThread2 t=new SubThread2();
        t.start();
        Thread.sleep(500);
        t.flag=false;
    }
}
