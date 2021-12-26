package com.nk.day1;

/**
 * @author lms
 * @date 2021-11-07 - 16:18
 */
public class NC11 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2};
        TreeNode root = new NC11().sortedArrayToBST(arr);
        System.out.println("root.val = " + root.val);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return build(num, 0, num.length - 1);
    }

    private TreeNode build(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num, left, mid - 1);
        root.right = build(num, mid + 1, right);
        return root;
    }
}
