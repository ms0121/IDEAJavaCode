package com.nk.day2;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-09-30 - 13:56
 */
public class NC55 {
    public static void main(String[] args) {
        String arr[] = {"abca", "abc", "abca", "abc", "abcc"};
        String prefix = longestCommonPrefix(arr);
        System.out.println("prefix = " + prefix);
    }

    // 计算最长的公共子串
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 对数组排序
        Arrays.sort(strs);
        int min = Math.min(strs[0].length(), strs[strs.length - 1].length());
        int i = 0;
        for (i = 0; i < min; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)){
                break;
            }
        }
        return strs[0].substring(0,i);
    }

}
