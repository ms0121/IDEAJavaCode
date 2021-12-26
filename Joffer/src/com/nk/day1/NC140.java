package com.nk.day1;


/**
 * @author lms
 * @date 2021-09-12 - 10:11
 */
public class NC140 {
    public static void main(String[] args) {
        int[] data = {1, 7, 4, 3, 9, 8, 10};
        MySort(data);
        print(data);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static int[] MySort(int[] arr) {
        // 直接执行快速排序即可
        quickSort(0, arr.length - 1, arr);
        return arr;
    }

    // 快速排序
    public static void quickSort(int first, int last, int[] arr) {
        // 数组只有一个元素的时候直接返回
        if (first >= last) {
            return;
        }
        int low = first, high = last;
        // 将第一个元素作为基准值
        int target = arr[first];
        while (low < high) {
            // 从右边开始遍历查找第一个小于target的值
            while (low < high && arr[high] >= target) {
                high--;
            }
            arr[low] = arr[high];

            // 从左边开始查找
            while (low < high && arr[low] <= target) {
                low++;
            }
            arr[high] = arr[low];
        }
        // 说明找到了target应当放置的位置
        arr[low] = target;

        // 左边进行遍历
        quickSort(first, low - 1, arr);
        // 右边进行遍历
        quickSort(low + 1, last, arr);
    }


    // 快速排序
    public static void quickSort1(int firt, int last, int[] arr) {
        // 如果只有一个元素，直接返回即可
        if (firt >= last) {
            return;
        }
        // 区第一个值作为基准值
        int midValue = arr[firt];
        int low = firt, high = last;
        // 循环执行的条件
        while (low < high) {
            // 先从右边的最后一个元素进行判断并进行移动
            while (low < high && arr[high] >= midValue) {
                high--;
            }
            arr[low] = arr[high];

            // 交换之后，从左边开始比较排序
            while (low < high && arr[low] <= midValue) {
                low++;
            }
            arr[high] = arr[low];
        }
        // 最后交汇的地方就是midValue应当要放置在数组的位置
        arr[low] = midValue;
        // 基准值左边的数组元素进行快速排序
        quickSort(firt, low - 1, arr);
        // 基准值右边的数组元素进行快速排序
        quickSort(low + 1, last, arr);
    }
}
