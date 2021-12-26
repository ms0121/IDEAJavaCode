package com.liu.day3;

import java.net.Inet4Address;

/**
 * @author lms
 * @date 2021-08-13 - 17:32
 * <p>
 * 输入：[1,2,3,1,2,3,2,2]
 * 返回值：3
 * 说明：最长子数组为[1,2,3]
 */
public class NC41 {
    public static void main(String[] args) {
        int arr[] = {1, -2, 3, 5, -2, 6, -1};
        int subarray = maxsumofSubarray(arr);
        System.out.println("subarray = " + subarray);
    }


    /**
     * NC19，求子数组的最大累加和问题
     * 通过将最大的值设置在当前访问的数组的前面一个位置，然后在让当前的
     * 值加上前面的最大的那个值，最后判断最大的值
     * @param arr
     * @return
     */
    public static int maxsumofSubarray (int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i] + arr[i-1]);
            m = Math.max(m, arr[i]);
        }
        return m;
    }


    public static int maxLength(int[] arr) {
        // write code here
        if (arr.length == 0){
            return 0;
        }
        if (arr.length == 1){
            return 1;
        }
        int index = 0, max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                index = i;
            }
            max = Math.max(max, i - index + 1);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                index = i;
            }
            max = Math.max(max, i - index + 1);
        }
        return max;
    }
}
