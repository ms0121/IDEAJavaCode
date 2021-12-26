package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-26 - 18:18
 */
public class NC_13 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        node2.left = node4;
        root.right = node3;
        node3.right = node5;
        int depth = maxDepth(root);
        System.out.println("depth = " + depth);
    }

    /**
     * 计算二叉树的深度
     * @param root
     * @return
     */
    public static int maxDepth (TreeNode root) {
        // write code here
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
