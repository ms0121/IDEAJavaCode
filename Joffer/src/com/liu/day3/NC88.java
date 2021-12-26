package com.liu.day3;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-07-03 - 14:41
 */
public class NC88 {
    public static void main(String[] args) {
        int a[] = {1,3,5,2,2};
        int kth = findKth(a, 5, 3);
        System.out.println("kth = " + kth);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a); // 默认从小到大进行排序
        return a[n - K];
    }
}
