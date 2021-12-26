package com.liu.leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lms
 * @date 2021-08-22 - 20:20
 */
public class L_1 {
    public static void main(String[] args) {
        int[] data = {11, 2, 15, 7, 3, 9};
        int[] arr = getIndex(data, 18);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static int[] getIndex(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])){
                return new int[]{i, map.get(target - array[i])};
            }
        }
        return null;
    }

}
