package com.liu.interview3;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author lms
 * @date 2021-08-12 - 23:29
 */
public class LongOrder {
    public static void main(String[] args) {
        int arr[] = {3,3,2,1,3,3,3,1};
        int max = longestOrder(arr);
        System.out.println("max = " + max);
    }

    /**
     * 最长连续递增序列： 给定一个未经排序的整数数组，找到最长并且连续的递增的子序列
     * 并且返回该序列的长度，要求序列的下标是连续的
     * 例如： {1,2,3,2,3,4,3,4,5,6,7}
     * 最长的序列是: {3,4,5,6,7}   len = 5
     *
     * @param arr
     * @return
     */
    public static int longestOrder(int[] arr) {
        int left = 0, right = 0, max = 0;
        HashSet<Integer> set = new HashSet<>();
        while (right < arr.length){
            if (set.contains(arr[right])){
                set.remove(arr[left++]);
            }else {
                set.add(arr[right++]);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

}
