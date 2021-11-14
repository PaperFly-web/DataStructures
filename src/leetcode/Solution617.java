package leetcode;

import java.util.Stack;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //1.确定终止条件
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        //2.处理逻辑
        //3.递归返回
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left = this.mergeTrees(root1.left,root2.left);
        root.right = this.mergeTrees(root1.right,root2.right);
        return root;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        //1.判断边界条件
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);
        stack.push(root2);
        while (!stack.isEmpty()) {
            TreeNode node2 = stack.pop();
            TreeNode node1 = stack.pop();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                stack.push(node1.left);
                stack.push(node2.left);
            } else {
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }

            if (node1.right != null && node2.right != null) {
                stack.push(node1.right);
                stack.push(node2.right);
            } else {
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }
        }
        return root1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
