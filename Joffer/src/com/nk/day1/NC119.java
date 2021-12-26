package com.nk.day1;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author lms
 * @date 2021-09-12 - 11:16
 */
public class NC119 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution2(arr, k);
        System.out.println("list = " + list);
    }


    // 使用优先队列的方式，设置队列的大小是k
    // 优先队列的底层是使用小根堆实现的，如果要转为大根堆，在创建优先队列的时候需要重写Comparator函数式接口
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || input.length == 0 || k == 0) {
            return list;
        }
        // 创建大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return o2 - o1;
        });
        for (int i : input) {
            if (queue.size() < k) {
                queue.add(i);
            } else {
                if (i < queue.peek()) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        // 快速排序
        quickSort(0, input.length - 1, input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    // 快速排序
    public static void quickSort(int first, int last, int[] arr) {
        // 只有一个元素
        if (first >= last) {
            return;
        }
        int low = first, high = last, midValue = arr[first];
        while (low < high) {
            // 计算右边的值
            while (low < high && arr[high] >= midValue) {
                high--;
            }
            arr[low] = arr[high];

            // 计算左边的值
            while (low < high && arr[low] <= midValue) {
                low++;
            }
            arr[high] = arr[low];
        }
        // 说明已经找到当前基准值要放置的位置
        arr[low] = midValue;
        // 左边进行快速排序
        quickSort(first, low - 1, arr);
        // 右边进行快速排序
        quickSort(low + 1, last, arr);
    }


}
