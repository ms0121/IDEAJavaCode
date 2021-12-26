package com.nk.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lms
 * @date 2021-10-09 - 20:57
 */
public class NC149 {
    public static void main(String[] args) {
        String s1 = "abab", s2 = "abacabab";
        int kmp = kmp(s1, s2);
        System.out.println("kmp = " + kmp);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,1);
    }

    public static int kmp(String S, String T) {
        for (int i = 0; i < T.length(); i++) {
            int k = 0;
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j + k) == T.charAt(i + k)){
                    k++;
                }else {
                    continue;
                }
            }
        }
        return 0;
    }





    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        if (list.size() == 0){
            return new int[]{};
        }else {
            int[] ints = new int[list.size()];
            int j = 0;
            for (Integer i : list) {
                ints[j++] = i;
            }
            return ints;
        }
    }
}
