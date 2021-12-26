package com.nk.day1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lms
 * @date 2021-11-07 - 15:43
 */
public class NC111 {
    public static void main(String[] args) {
        int[] arr = {3,123,32};
        String res = solve(arr);
        System.out.println("res = " + res);
    }

    public static String solve (int[] nums) {
        if (nums.length == 0){
            return "";
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] + "";
        }
        // 进行降序排序
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        // 如果第一个字符串是 0，则直接返回0字符串
        if (res[0].equals("0")){
            return res[0];
        }
        StringBuilder builder = new StringBuilder();
        for (String re : res) {
            builder.append(re);
        }
        return builder.toString();
    }
}
