package com.liu.array;

import jdk.nashorn.internal.objects.NativeNumber;

import java.awt.*;

/**
 * @author lms
 * @date 2021-03-31 - 10:06
 */
public class BstPost {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 8, 7, 5};
        BstPost bstPost = new BstPost();
        Node root = bstPost.posArrayToBst(arr);
//        if (root != null){
//            root.infixOrder();
//        }
        root.infixOrder();
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        // 中序遍历
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this.data);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }
    }

    public Node posArrayToBst(int[] arr) {
        return PostTree(arr, 0, arr.length - 1);
    }

    /**
     * 通过二叉搜索树的后续遍历列表实现搜索树的构建
     */
    public Node PostTree(int[] arr, int L, int R) {
        if (L > R) {
            return null;
        }
        // 构建根节点
        int val = arr[R];
        Node head = new Node(val);
        if (L == R) {
            return head;
        }

        // 寻找根节点的左子树部分和右子树部分
        // 防止出现是单支树
        int M = L - 1;
        for (int i = L; i < R; i++) {
            if (arr[i] < arr[R]) {
                M = i;
            }
        }

        // 分别构建左子树和右子树
        head.left = PostTree(arr, L, M);
        head.right = PostTree(arr, M + 1, R - 1);
        return head;
    }
}
