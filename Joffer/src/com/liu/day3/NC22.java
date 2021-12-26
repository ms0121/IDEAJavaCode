package com.liu.day3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author lms
 * @date 2021-07-03 - 13:28
 */
public class NC22 {
    public static void main(String[] args) {
        int a[] = {4, 5, 6, 0, 0, 0};
        int b[] = {1, 2, 3};
        merge(a, 3, b, 3);
    }

    public static void merge(int A[], int m, int B[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(A[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(B[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < m + n; i++) {
            A[i] = list.get(i);
        }
    }
}
