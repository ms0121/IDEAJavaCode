package com.liu.thread.ato;

import java.util.Random;

/**
 * @author lms
 * @date 2021-10-10 - 8:15
 * 通过线程来模拟请求，偶数代表请求成功，奇数代表请求失败
 */
public class IndicatorTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 记录请求总数
                    Indicator.getInstance().addAllRequest();
                    int num = new Random().nextInt();
                    if (num % 2 == 0){
                        Indicator.getInstance().addSuccessRequest();
                    }else {
                        Indicator.getInstance().addFailureRequest();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Indicator instance = Indicator.getInstance();
        System.out.println("instance.getAllRequest() = " + instance.getAllRequest());
        System.out.println("instance.getSuccessRequest() = " + instance.getSuccessRequest());
        System.out.println("instance.getFailureRequest() = " + instance.getFailureRequest());

    }
}
