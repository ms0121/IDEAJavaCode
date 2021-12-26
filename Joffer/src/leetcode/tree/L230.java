package leetcode.tree;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-24 - 10:12
 */
public class L230 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        root.left = node;
        root.right = node1;
        node.right = node2;

        int kthSmallest = kthSmallest(root, 1);
        System.out.println("kthSmallest = " + kthSmallest);

    }

    public static ArrayList<Integer> list = new ArrayList<>();
    public static int kthSmallest(TreeNode root, int k) {
        preOrder(root);
        Collections.sort(list);
        return list.get(k-1);
    }


    public static void preOrder(TreeNode root){
        if (root != null){
            preOrder(root.left);
            list.add(root.val);
            preOrder(root.right);
        }
    }
}
