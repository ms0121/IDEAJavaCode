package leetcode.tree;

import java.util.*;

/**
 * @author lms
 * @date 2021-10-31 - 9:09
 */
public class L102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(9);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(7);

        root.left = node;
        root.right = node1;
        node1.left = node2;
        node1.right = node3;

        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);


    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while(stack1.size() > 0 || stack2.size() > 0){
            if(stack1.size() > 0){
                List<Integer> subList = new ArrayList<Integer>();
                int count = stack1.size();
                for(int i=0;i<count;i++){
                    TreeNode node = stack1.pop();
                    subList.add(node.val);
                    if(node.left != null){
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                }
                res.add(subList);
            }else {
                List<Integer> subList = new ArrayList<Integer>();
                int count = stack2.size();
                for(int i=0;i<count;i++){
                    TreeNode node = stack2.pop();
                    subList.add(node.val);
                    if(node.right != null){
                        stack1.push(node.right);
                    }
                    if(node.left != null){
                        stack1.push(node.left);
                    }
                }
                res.add(subList);
            }
        }
        return res;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return null;
        }
        // ????????????
        LinkedList<TreeNode> queue = new LinkedList<>();
        // ??????????????????????????????
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            // ???????????????????????????(??????????????????????????????????????????)
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                // ?????????????????????????????????????????????
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
