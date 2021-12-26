package com.liu.interview2;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-04-10 - 22:38
 */
public class L_o_50 {
    public static void main(String[] args) {
        String  s = "abaccdeff";
//        firstUniqChar(s);
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.remove('a');
        System.out.println("list = " + list);
    }

    //    s = "abaccdeff"
    //    返回 "b"
    public static void firstUniqChar(String s) {
        ArrayList<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (list.contains(aChar)){
                list.remove(aChar);
            }else {
                list.add(chars[i]);
            }
        }
        System.out.println("list = " + list);
    }
}
