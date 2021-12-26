package com.liu.interview3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-13 - 20:00
 */
public class TreeTraverse {
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

//        preOrder(root);
//        preOrder2(root);
//        fixOrder(root);
//        postOrder(root);
//        levelOrder(root);
    }

    // 先序遍历(递归)
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("root = " + root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


    // 先序遍历(非递归),先进后出
    public static void preOrder2(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
            System.out.println("temp.val = " + temp.val);
        }
    }


    // 中序
    public static void fixOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        fixOrder(root.left);
        System.out.println("root = " + root.val);
        fixOrder(root.right);
    }

    // 后序
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("root = " + root.val);
    }

    // 层次遍历
    public static void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
            System.out.println("temp.val = " + temp.val);
        }
    }

}
