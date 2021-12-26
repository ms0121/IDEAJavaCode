package com.nk.day1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lms
 * @date 2021-09-12 - 16:04
 */
public class NC41 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,3,2,1,0};
        int i = maxLength(arr);
        System.out.println("i = " + i);
    }

    // 求最长无重复子数组
    // [1,3,5,7,9] ===>  子数组： [1,3]，[3,5,7]， 最长的为：[3,5,7]
    // 方式1：使用队列，如果队列中有重复的元素就队首出队，直到队列中没有相同的元素即可
    public static int maxLength(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        for (int elem : arr) {
            while (queue.contains(elem)){
                // 如果队列存在当前元素，就不断的出队，直到队列中没有当前元素的存在
                queue.poll();
            }
            queue.add(elem);
            // 每添加一个元素进入到队列中都判断当前的最大子数组的长度
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
