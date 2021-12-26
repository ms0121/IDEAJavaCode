package com.nk.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-09-15 - 11:19
 */
public class NC8 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;

        root.right = node2;
        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;

        ArrayList<ArrayList<Integer>> lists = pathSum(root, 22);
        System.out.println("lists = " + lists);
    }

    public static ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    /**
     * 从上往下进行计算，每往下一层计算，都减去上一层的值
     * @param root
     * @param sum
     * @param list
     * @param result
     */
    public static void dfs(TreeNode root, int sum, ArrayList<Integer> list, List<ArrayList<Integer>> result){
        if (root == null){
            return;
        }
        // 构建一个字列表（主要用于存放遍历的节点值）
        ArrayList<Integer> sublist = new ArrayList<>(list);
        // 记录当前二叉树的每一条路径信息
        sublist.add(root.val);
        // System.out.println("sublist = " + sublist);
        // 如果到达根节点，则进行判断根节点的值和target值是否相等，如果符合要求则将其添加到列表中
        // 如果不等，则直接删除这一条路径信息(也就是不加入到result结果表中)
        if (root.left == null && root.right == null){
            if (sum == root.val){
                result.add(sublist);
            }
            return;
        }
        // 然后从左边开始遍历，此时要传入的是当前正在使用的字列表
        dfs(root.left, sum - root.val, sublist, result);
        dfs(root.right, sum - root.val, sublist, result);
    }
}












