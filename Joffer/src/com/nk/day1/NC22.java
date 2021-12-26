package com.nk.day1;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author lms
 * @date 2021-09-12 - 19:52
 */
public class NC22 {
    public static void main(String[] args) {

    }

    public static void merge(int A[], int m, int B[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(A[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(B[i]);
        }
        // 重写排序的规则
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i);
        }
    }
}
