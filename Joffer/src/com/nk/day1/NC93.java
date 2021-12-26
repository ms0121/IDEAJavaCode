package com.nk.day1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-14 - 19:22
 */
public class NC93 {
    public static void main(String[] args) {

    }

    // 计算最长递增子序列
    public static int[] LRU (int[][] operators, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator.length == 3){
                map.put(operator[1], operator[2]);
            }else {
                list.add(map.get(operator[1]));
            }
        }
        System.out.println("list = " + list);
        return null;
    }

}
