package com.nk.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-09-12 - 10:45
 */
public class NC45 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);

        root.left = node;
        root.right = node1;
        node.left = node2;

        int[][] arr = threeOrders(root);

        System.out.println("arr.length = " + arr.length);
        System.out.println("arr[0].length = " + arr[0].length);

        print(arr);

    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] threeOrders (TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        preOrder(root, list1);
        suffixOrder(root, list2);
        postOrder(root, list3);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        // 创建返回值数组
        int[][] result = new int[3][list1.size()];
        // 遍历ArrayList中的每个元素
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < list1.size(); j++) {
                result[i][j] = lists.get(i).get(j);
            }
        }
        return result;
    }

    // 前序遍历
    public static void preOrder(TreeNode root, List<Integer> list){
        if (root != null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    // 中序遍历
    public static void suffixOrder(TreeNode root, List<Integer> list){
        if (root != null){
            suffixOrder(root.left, list);
            list.add(root.val);
            suffixOrder(root.right, list);
        }
    }

    // 后序遍历
    public static void postOrder(TreeNode root, List<Integer> list){
        if(root != null){
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }
}
