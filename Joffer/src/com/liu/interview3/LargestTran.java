package com.liu.interview3;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-08-13 - 19:37
 * 找出三角形中的最大周长
 * 给定由一些正数(代表长度)组成的数组arr，返回由其中三个长度组成的
 * 面积不为零的三角形的最大周长
 * 如果不能组成任何有效的三角形，则返回0
 */
public class LargestTran {
    public static void main(String[] args) {
        int arr[] = {3,2,6,4};
        int max = findMax(arr);
        System.out.println("max = " + max);
    }

    /**
     * 满足三角形的条件：a + b > c && a < c && b < c
     * 解题思路：先将给定的数组进行排序(从小到大)，这样子从后面开始往前找，
     * 如果不能满足，就往前找一个
     *
     * @param arr
     * @return
     */
    public static int findMax(int arr[]){
        // 先对数组进行排序
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            if (arr[i-2] + arr[i-1] > arr[i]){
                return arr[i-2] + arr[i-1] + arr[i];
            }
        }
        return 0;
    }
}
