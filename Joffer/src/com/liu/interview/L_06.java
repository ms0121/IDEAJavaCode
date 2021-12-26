package com.liu.interview;


import java.util.Arrays;

/**
 * @author lms
 * @date 2021-04-04 - 22:54
 */
public class L_06 {
    public static void main(String[] args) {
//        String s = "aabcccccaaa";
        String s = "abbccd";
        String s1 = compressString(s);
        System.out.println("s1 = " + s1);

    }

    // 输入："aabcccccaaa"
    // 输出："a2b1c5a3"
    // 直接通过必要的信息进行删除不需要的数据
    public static String compressString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = S.toCharArray();
        int count = 0;
        int i, j;
        for (i = 0; i < chars.length; i = j) {
            for (j = i; j < chars.length; ) {
                if (chars[i] == chars[j]) {
                    count++;
                } else {
                    stringBuilder.append(chars[i]);
                    stringBuilder.append(j-i);
                    break;
                }
                if (j == chars.length - 1 && chars[i] == chars[j]){
                    stringBuilder.append(chars[i]);
                    stringBuilder.append(j-i+1);
                }
                j++;
            }
        }
        if (stringBuilder.length() < S.length()){
            return stringBuilder.toString();
        }else {
            return S;
        }
    }
}
