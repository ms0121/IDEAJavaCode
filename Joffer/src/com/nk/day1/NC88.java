package com.nk.day1;

import java.util.PriorityQueue;

/**
 * @author lms
 * @date 2021-09-12 - 13:21
 */
public class NC88 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,10,4,6,9,2};
        int n = arr.length, k = 3;
        int kth = findKth(arr, n, k);
        System.out.println("kth = " + kth);
    }

    public static int findKth(int[] a, int n, int K) {
        // 优先队列，第一个永远是最小的元素值
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (queue.size() < K){
                queue.add(a[i]);
            }else if (a[i] > queue.peek()){
                // 如果当前数组的值大于队列中第一个值，则出队，然后将大者入队
                queue.poll();
                queue.add(a[i]);
            }
        }
        return queue.peek();
    }

}
