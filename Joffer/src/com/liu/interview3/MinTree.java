package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-11 - 17:12
 *
 * 求一棵二叉树的最小深度
 *
 *
 */
public class MinTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        root.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        root.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode6.left = treeNode7;

        int deep = minDeepDfs(root);
        System.out.println("deep = " + deep);
    }

    // 深度优先遍历，逆着往回找
    public static int minDeepDfs(TreeNode root){
        if (root == null){
            return 0;
        }

        // 通过这一行找到叶子结点
        if (root.left == null && root.right == null){
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null){
            min = Math.min(minDeepDfs(root.left), min);
        }
        if (root.right != null){
            min = Math.min(minDeepDfs(root.right), min);
        }
        return min + 1;
    }

}
