package leetcode.tree;

import com.sun.istack.internal.NotNull;

/**
 * @author lms
 * @date 2021-11-01 - 20:59
 */
public class L106 {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder, postorder);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return build(inorder, postorder, 0, len - 1, len);
    }

    public static TreeNode build(int[] inorder, int[] postorder, int inS, int posS, int len){
        if (len <= 0){
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(postorder[posS]);
        int k = 0;
        while (postorder[posS] != inorder[inS + k]){
            k++;
        }
        root.left = build(inorder, postorder, inS, inS + k - 1, k);
        root.right = build(inorder, postorder, inS + k + 1, posS - 1, len - k - 1);
        return root;
    }
}
