package com.liu.array;

/**
 * @author lms
 * @date 2021-08-28 - 14:15
 */
public class TestInsert {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,-1};
        int target = 3;
        insert(arr,  target);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void insert(int arr[], int target){
        // 数组的长度
        int len = arr.length;

        for (int i = 0; i < len; )
        {
            /* code */
            while (arr[i] < target)
            {
                i++;
            }
            for (int j = len-1; j > i;)
            {
                arr[j] = arr[--j];
            }
            arr[i] = target;
            break;
        }
    }
}
