package leetcode.tree;

/**
 * @author lms
 * @date 2021-10-24 - 10:01
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum-root.val);
    }
}
