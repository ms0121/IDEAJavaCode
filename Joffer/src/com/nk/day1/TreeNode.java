package com.nk.day1;

/**
 * @author lms
 * @date 2021-04-10 - 8:22
 */
public class TreeNode {
    int val = 0;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
