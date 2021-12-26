package com.liu.interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lms
 * @date 2021-04-02 - 22:28
 */
public class L_01 {
    public static void main(String[] args) {
        String s = "leetcode";
        boolean unique = isUnique(s);
        System.out.println("unique = " + unique);
    }

    public static boolean isUnique(String astr) {
        boolean flag = true;
        char[] chars = astr.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println("chars = " + chars[i]);
//        }
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (characters.contains(chars[i])){
                return false;
            }
            characters.add(chars[i]);
        }
        return flag;
    }
}
