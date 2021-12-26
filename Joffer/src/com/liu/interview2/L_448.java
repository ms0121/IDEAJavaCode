package com.liu.interview2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-13 - 22:23
 */
public class L_448 {
    public static void main(String[] args) {
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDuplicates(num);
        System.out.println("list = " + list);
    }


    public static List<Integer> findDuplicates(int[] nums) {
        return null;
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
