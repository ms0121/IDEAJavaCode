package com.nk.day1;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-09-22 - 22:52
 */
public class NC8 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPath(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    private void findPath(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (root == null){
            return;
        }
        ArrayList<Integer> subList = new ArrayList<>(list);
        subList.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == sum){
                result.add(subList);
            }
            return;
        }
        // 左右子树分别进行遍历
        findPath(root.left, sum - root.val, subList, result);
        findPath(root.right, sum - root.val, subList, result);
    }
}
