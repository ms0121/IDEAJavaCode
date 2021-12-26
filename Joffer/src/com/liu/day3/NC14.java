package com.liu.day3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-06 - 19:59
 */
public class NC14 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        root.left = treeNode;
        root.right = treeNode1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        ArrayList<ArrayList<Integer>> lists = Print(root);
        System.out.println("lists = " + lists);
    }


    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null){
            return result;
        }
        // 设置两个栈分别进行存放
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        // 将根节点压入栈1中
        stack1.push(pRoot);
        while (stack1.size() > 0 || stack2.size() > 0){
            ArrayList<Integer> subList = new ArrayList<>();
            if (stack1.size() > 0){
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack1.pop();
                    if (node.left != null){
                        stack2.push(node.left);
                    }
                    if (node.right != null){
                        stack2.push(node.right);
                    }
                    subList.add(node.val);
                }
                result.add(subList);
                // 执行完当前的栈跳转到下一次循环体
                continue;
            }

            // 上面的执行下面的就不会执行
            int size = stack2.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack2.pop();
                if (node.right != null){
                    stack1.push(node.right);
                }
                if (node.left != null){
                    stack1.push(node.left);
                }
                subList.add(node.val);
            }
            result.add(subList);
            // 执行完当前的栈跳转到下一次循环体
        }
        return result;
    }

}
