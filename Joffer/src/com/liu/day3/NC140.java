package com.liu.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lms
 * @date 2021-07-06 - 14:16
 */
public class NC140 {

    public static void main(String[] args) {
        int arr[] = {5,2,3,1,4};
        int[] ints = MySort(arr);
        System.out.println("Arrays.asList(ints) = " + Arrays.toString(ints));
    }


    /**
     * 快速排序
     * @param arr
     * @return
     *
     * def quick_sort(alist, first, last):
     *     # 列表的下标
     *     if first >= last:
     *         return
     *     # 选择出第一个元素的值，并在序列中找到他应该在的位置然后进行放置
     *     mid_value = alist[first]
     *     low = first
     *     high = last
     *     while low < high:
     *         # 先从右边即最后的元素进行判断进行移动
     *         while low < high and alist[high] >= mid_value:
     *             high -= 1
     *         alist[low] = alist[high]
     *
     *         # 然后开始从左边开始进行对比
     *         while low < high and alist[low] <= mid_value:
     *             low += 1
     *         alist[high] = alist[low]
     *     # 运行到这句代码说明满足了low==high，即已经遍历完一次
     *     alist[low] = mid_value
     *
     *     # 对low左边的序列进行同样的排序
     *     quick_sort(alist, first, low-1)
     *     # 对low右边的序列进行同样的排序
     *     quick_sort(alist, low+1, last)
     *
     */

    public static int[] MySort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    // 快速排序
    public static void quickSort(int[] arr, int first, int last) {
        if (first >= last){
            return;
        }

        int mid_value = arr[first];
        int low = first, high = last;
        while (low < high){
            // # 先从右边即最后的元素进行判断进行移动
            while( low < high && arr[high] >= mid_value){
                high -= 1;
            }
            arr[low] = arr[high];

            //然后开始从左边开始进行对比
            while (low < high && arr[low] <= mid_value){
                  low += 1;
            }
            arr[high] = arr[low];
        }
        // 运行到这句代码说明满足了low==high，即已经遍历完一次
        arr[low] = mid_value;

        quickSort(arr, first, low - 1);
        quickSort(arr, low + 1, last);
    }




    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] MySort1(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]){
                    k = j;
                }
            }
            if (k != i){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k > input.length){
            return list;
        }
        int t = 0;
        for (int i = 0; i < input.length; i++) {
            t = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[t] > input[j]){
                    t = j;
                }
            }
            if (t != i){
                int temp = input[i];
                input[i] = input[t];
                input[t] = temp;
            }
        }
        for(int i=0;i<t;i++){
            list.add(input[i]);
        }
        return list;
    }

}
