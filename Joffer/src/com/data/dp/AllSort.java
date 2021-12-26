package com.data.dp;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author lms
 * @date 2021-10-06 - 10:01
 */
public class AllSort {
    public static void main(String[] args) {
        int arr[] = {3, 8, 5, 9, 7, 4, 2, 1};
//        insertSort(arr);
//        bubbleSort(arr);
//        selectSort(arr);
        quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    // 冒泡排序
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int j = 0; j < n; j++) {  //表示执行多少次循环可以得到排序后的结果
            for (int i = 0; i < n - 1; i++) {  //
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }
    }

    // 选择排序
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int t = arr[i];
                arr[i] = arr[k];
                arr[k] = t;
            }
        }
    }

    // 插入排序
    public static void insertSort(int arr[]) {
        int n = arr.length;
        // 默认第一个有序，将后面的元素依次插入到前面排好序的数组中
        for (int j = 1; j < n; j++) {
            int i = j;
            while (i > 0) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    // 只有执行了操作才需要进行向前移动
                    i--;
                } else {
                    break;
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int arr[]) {
        quick(0, arr.length - 1, arr);
    }

    public static void quick(int first, int last, int arr[]) {
        // 只有一个元素或者交换完毕之后直接返回
        if (first >= last) {
            return;
        }
        int target = arr[first];
        int low = first, high = last;
        while (low < high) {
            while (low < high && arr[high] >= target) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= target) {
                low++;
            }
            arr[high] = arr[low];
        }
        // 找到基准值的存放位置
        arr[low] = target;
        // 分别进行左边右边遍历
        quick(first, low - 1, arr);
        quick(low + 1, last, arr);
    }
}
