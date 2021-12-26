package com.nk.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lms
 * @date 2021-09-14 - 16:33
 */
public class NC91 {
    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] lis = LIS(arr);


    }

    public static int[] LIS(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]){
                    if (tmp < (dp[j] + 1)){
                        tmp = dp[j] + 1;
                    }
                }
            }
            dp[i] = tmp;
            int len = list.size();
            if (dp[i] == dp[i-1]){
                list.remove(len - 1);
                list.add(len-1, arr[i]);
            }
            if (dp[i] > dp[i-1]){
                list.add(len, arr[i]);
            }
        }
        System.out.println("list = " + list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
