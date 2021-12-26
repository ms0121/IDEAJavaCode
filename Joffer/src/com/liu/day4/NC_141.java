package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-26 - 18:25
 */
public class NC_141 {
    public static void main(String[] args) {
        String str = "absbac";
        boolean flag = judge(str);
        System.out.println("flag = " + flag);
    }

    // 判断回文序列
    public static boolean judge (String str) {
        int len = str.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
