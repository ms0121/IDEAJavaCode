package com.liu.array;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author lms
 * @date 2021-03-31 - 23:34
 */
public class LC414 {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 1};
        int thirdMax = thirdMax(arr);
        System.out.println("thirdMax = " + thirdMax);
    }

    // 找出第三大的元素
    public static int thirdMax(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i: nums){
            if (!arrayList.contains(i)){
                arrayList.add(i);
            }
        }
        int[] newNums = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            newNums[i] = arrayList.get(i);
        }
        for (int i = 0; i < newNums.length; i++) {
            int k = i;
            for (int j = i + 1; j < newNums.length; j++) {
                if (newNums[k] < newNums[j]){
                    k = j;
                }
            }
            if (k != i){
                int temp = newNums[k];
                newNums[k] = newNums[i];
                newNums[i] = temp;
            }
        }
        if (newNums.length >= 3){
            return newNums[2];
        }else {
            return newNums[0];
        }
    }
}
