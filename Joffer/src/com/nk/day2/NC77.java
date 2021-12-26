package com.nk.day2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-30 - 20:23
 */
public class NC77 {
    public static void main(String[] args) {
        int[] arr = {2,4,6,5,7};
        reOrderArray(arr);
    }

    public static int[] reOrderArray (int[] array) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : array) {
            stack.push(i);
        }
        while (!stack.isEmpty()){
            // 偶数
            if (stack.peek() % 2 == 0){
                list1.add(stack.pop());
            }else {
                list2.add(stack.pop());
            }
        }
        int j = 0;
        for (int i = list2.size() - 1; i >= 0 ; i--) {
            array[j] = list2.get(i);
            j++;
        }

        for (int i = list1.size()-1; i >= 0 ; i--) {
            array[j] = list1.get(i);
            j++;
        }
        return array;
    }

}
