package com.nk.day2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-09-15 - 10:11
 */
public class NC136 {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        TreeNode node = new TreeNode(2);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(5);
//        root.left = node;
//        root.right = node1;
//        node.left = node2;
//        node.right = node3;
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(root.val);
//        rightTraverse(root, list);
//        System.out.println("list = " + list);


        int[] xianxu = {1, 2, 4, 5, 6, 3};
        int[] zhongxu = {5, 4, 6, 2, 1, 3};
        int[] solve = solve(xianxu, zhongxu);

    }

    // 返回二叉树的右视图
    public static int[] solve(int[] xianxu, int[] zhongxu) {
        // 构建的二叉树
        TreeNode root = curTree(xianxu, zhongxu, 0, 0, xianxu.length);

        ArrayList<Integer> list = new ArrayList<>();
        rightTraverse(root, list);
        System.out.println("list = " + list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // 右边遍历
    public static void rightTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.right != null) {
                list.add(root.val);
                list.add(root.right.val);
            }
            rightTraverse(root.left, list);
            rightTraverse(root.right, list);
        }
    }


    /**
     * 根据先序中序重新构建当前的二叉树
     *
     * @param pre      先序遍历数组
     * @param vin      中序遍历数组
     * @param preStart 先序数组的起始位置
     * @param vinStart 中序数组的起始位置
     * @param len      当前的数组的长度
     * @return
     */
    public static TreeNode curTree(int[] pre, int[] vin, int preStart, int vinStart, int len) {
        if (len == 0) {
            return null;
        }
        // 每个子树的根节点
        TreeNode root = new TreeNode(pre[preStart]);
        int k = 0;
        // 找到先序数组的分割点
        while (pre[preStart] != vin[vinStart + k]) {
            // 找到中间的节点
            k++;
        }
        // 构建左子树
        root.left = curTree(pre, vin, preStart + 1, vinStart, k);
        // 构建右子树,
        root.right = curTree(pre, vin, preStart + k + 1, vinStart + k + 1, len - k - 1);
        return root;
    }
}
