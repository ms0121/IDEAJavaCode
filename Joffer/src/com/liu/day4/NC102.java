package com.liu.day4;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author lms
 * @date 2021-08-16 - 23:34
 */
public class NC102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        int ancestor = lowestCommonAncestor(root, 6, 7);
        System.out.println("ancestor = " + ancestor);

    }


    // 查找当前指定的孩子节点的最近父节点
    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        // 记录遍历到的每个节点的父节点
        HashMap<Integer, Integer> parent = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点没有父节点，给他一个默认值
        parent.put(root.val, Integer.MIN_VALUE);
        queue.add(root);
        // 使用层次遍历的方式
        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            // poll 出队函数
            TreeNode node = queue.poll();

            // 处理左子树
            assert node != null;
            if (node.left != null) {
                //左子节点不为空，记录它的父节点
                parent.put(node.left.val, node.val);
                // 将左子节点入队
                queue.add(node.left);
            }

            // 处理右子树
            if (node.right != null) {
                //右子节点不为空，记录它的父节点
                parent.put(node.right.val, node.val);
                // 将右子节点入队
                queue.add(node.right);
            }
        }
        // 记录o1和它的祖先节点，从o1节点开始一直到根节点
        HashSet<Integer> set = new HashSet<>();
        while (parent.containsKey(o1)) {
            set.add(o1);
            o1 = parent.get(o1);
        }
        //查看o1和他的祖先节点是否包含o2节点，如果不包含再看是否包含o2的父节点……
        while (!set.contains(o2)) {
            o2 = parent.get(o2);
        }
        return o2;
    }

}
