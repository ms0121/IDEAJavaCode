package com.liu.interview3;

import java.text.ParsePosition;

/**
 * @author lms
 * @date 2021-08-09 - 19:19
 */
public class Feibo {
    public static void main(String[] args) {
//        int recuse = recuse(8);
        int point = twoPoint(8);
        System.out.println("recuse = " + point);
    }

    // 方法二：使用双指针的方式进行逐个遍历计算
    public static int twoPoint(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int low = 0, high = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }


    // 方法一： 使用递归计算斐波那契数列;
    public static int recuse(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recuse(n - 1) + recuse(n - 2);
    }
}
