package com.liu.day4;

import com.sun.corba.se.pept.transport.ResponseWaitingRoom;

/**
 * @author lms
 * @date 2021-08-26 - 18:29
 */
public class NC_62 {
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
        boolean flag = IsBalanced_Solution(root);
        System.out.println("flag = " + flag);
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1){
            return false;
        }else {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
    }

    public static int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
