package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-26 - 19:30
 */
public class NC_5 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        root.left = node2;
        root.right = node3;
        int numbers = sumNumbers(root);
        System.out.println("numbers = " + numbers);
    }

    public static int sumNumbers (TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return root.val;
        }
        if (root.left != null && root.right == null){
            return root.val*10 + sumNumbers(root.left);
        }
        if (root.left == null){
            return root.val*10 + sumNumbers(root.right);
        }
        return root.val*10 + sumNumbers(root.left) + root.val*10 + sumNumbers(root.right);
    }
}
