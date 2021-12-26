package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-08 - 22:25
 * 题目： 计算x的平方根的整数部分值（不允许使用sqrt函数进行直接开方的计算）
 */
public class Xsqrt {
    public static void main(String[] args) {
//        int xsqrt = xsqrt(26);
        int newtown = newtown(37);
        System.out.println("xsqrt = " + newtown);
    }

    // 方法一： 使用二分查找的方法进行
    public static int xsqrt(int x) {
        int index = 0, l = 0, r = x;
        while (l <= r) {
            // 计算中间值
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }


//   方法二：牛顿迭代法
    public static int newtown(int x){
        if (x == 0){
            return 0;
        }
        return (int) sqrt(x, x);
    }

    // 迭代
    public static double sqrt(double i, int x){
        // 牛顿迭代的特点是当i == x/i的时候，说明i^2 = x,即i为x的平方根
        // 两者之间的平均值无限接近平方根
        double res = (i + x / i) / 2;
        if (res == i){
            return i;
        }else {
            // 如果两只不相等，那么就将平均值继续带入到公式当中进行进一步的计算
            return sqrt(res, x);
        }
    }

}
