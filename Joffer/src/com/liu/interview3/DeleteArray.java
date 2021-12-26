package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-08 - 21:33
 */
public class DeleteArray {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        int i = deleteRef(arr);
        System.out.println("i = " + i);
    }

    /**
     * 使用双指针的方法计算数组中不重复元素的个数(不能使用额外的数组空间，保证空间复杂度为O(1))
     * 该方法体的计算规则就是将块指针指向的元素和慢指针的进行对比，如果不相等，则块指针继续往后移，
     * 直到不相等，再将快指针的元素值赋给慢指针的后一个元素array[i+1] = array[j]
     */
    public static int deleteRef(int array[]) {
        if (array.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                i++;
                array[i] = array[j];
            }
        }
        return (i + 1);
    }
}
