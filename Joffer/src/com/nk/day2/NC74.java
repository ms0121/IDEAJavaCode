package com.nk.day2;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-30 - 20:14
 */
public class NC74 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        int i = GetNumberOfK(arr, 6);
        System.out.println("i = " + i);
    }

    public static int GetNumberOfK(int[] array, int k) {
        HashMap map = new HashMap<Integer, Integer>();
        for (int tmp : array) {
            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                Integer v = (Integer) map.get(tmp);
                map.put(tmp, v + 1);
            }
        }
        if (map.containsKey(k)){
            return (int) map.get(k);
        }else {
            return 0;
        }
    }
}
