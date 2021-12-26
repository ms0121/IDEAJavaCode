package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 15:43
 */
public class NC19 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int max = maxsumofSubarray(arr);
        System.out.println("max = " + max);
    }

    // [1, -2, 3, 5, -2, 6, -1] ==> 12
    public static int maxsumofSubarray (int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 更新到达每个位置的最大值
            arr[i] = Math.max(arr[i], arr[i] + arr[i-1]);
            // 更新最大的值
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
