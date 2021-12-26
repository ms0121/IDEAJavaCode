package com.nk.day1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author lms
 * @date 2021-09-12 - 12:50
 */
public class NC15 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(9);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(8);

        root.left = node;
        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        node.left = node4;
        node.right = node5;

    }

    // 实现二叉树的层次遍历
    public static ArrayList<ArrayList<Integer>> levelOrder1 (TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return null;
        }
        // 不为空树
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 将根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            // 记录当前队列的长度(也就是每一层当前拥有的节点数)
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                // 将当前出队的节点添加到子列表中
                subList.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
