package com.nk.day1;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-10-09 - 20:35
 */
public class NC95 {

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        int mls = MLS(arr);
        System.out.println("mls = " + mls);
    }

    public static int MLS(int[] arr) {
        if (arr.length == 0){
            return 0;
        }
        if (arr.length == 1){
            return 1;
        }
        Arrays.sort(arr);
        int max = 0;
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                continue;
            if (arr[i] - arr[i - 1] == 1) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }



    public static void quickSort(int first, int last, int arr[]) {
        if (first >= last) {
            return;
        }
        int value = arr[first];
        int low = first, high = last;
        while (low < high) {
            while (low < high && arr[high] >= value) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= value) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = value;
        quickSort(first, low - 1, arr);
        quickSort(low + 1, last, arr);
    }
}
