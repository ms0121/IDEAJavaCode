package com.liu.interview2;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-04-11 - 16:27
 */
public class L_03 {

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "pwwkew";
//        String s = "bbbb";
        String s = "";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }

    // 1.设置一个列表用来记录当前的不重复字符
    // 2.设置k记录当前列表中的最长不重复子串
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        char ch;
        int max = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            ch = chars[i];
            if (!list.contains(ch)){
                list.add(ch);
                count++;
            }else {
                if (max < count){
                    max = count;
                }
                list.clear();
                count = 0;
                list.add(ch);
                count++;
            }
        }
        return max;
    }
}
