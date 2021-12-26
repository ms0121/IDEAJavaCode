package com.nk.day2;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-11-05 - 23:02
 */
public class NC128 {
    public static void main(String[] args) {

    }

    public long maxWater(int[] arr) {
        if (arr.length <= 2) {
            return 0;
        }
        // write code here
        int max = arr[0];
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]){
                list.add(max - arr[i]);
            }else {
                max = arr[i];
            }
        }
        return 0;
    }
}
