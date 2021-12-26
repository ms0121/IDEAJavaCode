package com.liu.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-07-03 - 14:34
 */
public class NC45 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        root.left = t1;
        root.right = t2;

        int[][] ints = threeOrders(root);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 设置一个二数组进行存放遍历后的信息，因为返回的是一二维数组，所以应当要设置一个全局的list进行存放
     * 遍历后的信息
     * @param root
     * @return
     */
    public static int[][] threeOrders (TreeNode root) {
        int[][] array = new int[3][];
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        pre(root, list1);
        suffix(root, list2);
        post(root, list3);
        array[0] = new int[list1.size()];
        array[1] = new int[list2.size()];
        array[2] = new int[list3.size()];
        for (int i = 0; i < list1.size(); ++i){
            array[0][i] = list1.get(i);
            array[1][i] = list2.get(i);
            array[2][i] = list3.get(i);
        }
        return array;
    }

    public static void pre(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            pre(root.left, list);
            pre(root.right, list);
        }
    }


    public static void suffix(TreeNode root, List<Integer> list) {
        if (root != null) {
            suffix(root.left, list);
            list.add(root.val);
            suffix(root.right, list);
        }
    }

    public static void post(TreeNode root, List<Integer> list) {
        if (root != null) {
            post(root.left, list);
            post(root.right, list);
            list.add(root.val);
        }
    }
}
