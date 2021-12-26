package com.liu.day3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author lms
 * @date 2021-07-03 - 13:16
 */
public class NC119 {
    public static void main(String[] args) {
        int input[] = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(input, 4);
    }

    /**
     * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * 如果K>数组的长度，那么返回一个空的数组.
     *
     * 输入：
     *  [4,5,1,6,2,7,3,8],4
     * 返回值：
     *  [1,2,3,4]
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : input) {
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list1.add(list.get(i));
        }
        System.out.println("list = " + list1);
        return list1;
    }
}
