package com.liu.interview;

import sun.reflect.generics.tree.Tree;

/**
 * @author lms
 * @date 2021-04-10 - 9:16
 */
public class L_15 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        boolean balanced = isBalanced(treeNode);
        System.out.println("balanced = " + balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int abs = Math.abs(maxDepth(root.left) - maxDepth(root.right));
        if (abs > 1){
            return false;
        }
        isBalanced(root.left);
        isBalanced(root.right);
        return true;
    }

    // 计算左右子树的高度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l : r;
    }

}
