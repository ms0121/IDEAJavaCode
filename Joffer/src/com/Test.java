package com;

import java.util.*;

/**
 * @author lms
 * @date 2021-10-12 - 14:16
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = {4,3,1,-3,2};
        int one = getTwo(arr);
        System.out.println(one);
    }

    // 4 3 1
    public static List<ArrayList<Integer>> get(int[] arr){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        return lists;
    }


    public static int getTwo(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            // 0 3 3
            dp[i] = Math.max(arr[i] * dp[i-1], arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static int getOne(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int flag = -1;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1){
                flag = entry.getKey();
            }
        }
        return flag;
    }

}
