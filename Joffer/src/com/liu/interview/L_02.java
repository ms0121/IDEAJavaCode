package com.liu.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lms
 * @date 2021-04-02 - 22:37
 */
public class L_02 {
    public static void main(String[] args) {
        String s1 = "aba", s2 = "aab";
        boolean flag = CheckPermutation(s1, s2);
        System.out.println("flag = " + flag);


    }

    //    输入: s1 = "abc", s2 = "bca"
    //    输出: true
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // getOrDefault (Object key, V defaultValue) 方法 是 Map 接口下的一个 方法 。
        // 作用：当 Map 集合 中 有这个 key 时，就 使用 这个 key 值；如果没有就 使用 默认值 defaultValue
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // System.out.println("map1 = " + map1);
        // System.out.println("map2 = " + map2);
        for (int i = 0; i < s1.length(); i++) {
            if (map1.get(s1.charAt(i)) != map2.get(s1.charAt(i)))
                return false;
        }
        return true;
    }
}
