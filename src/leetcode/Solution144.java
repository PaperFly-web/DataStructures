package leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(4);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(2);
        Solution144 s = new Solution144();
        s.preorderTraversal(t);
    }
    //前序
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node!=null) {
                //右
                if (node.right != null) {
                    stack.push(node.right);
                }
                //左
                if (node.left != null) {
                    stack.push(node.left);
                }
                //中
                stack.push(node);
                stack.push(null);


            } else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
    //中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node!=null) {
                //右
                if (node.right != null) {
                    stack.push(node.right);
                }
                //中
                stack.push(node);
                stack.push(null);
                //左
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    //后序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node!=null) {
                //中
                stack.push(node);
                stack.push(null);
                //右
                if (node.right != null) {
                    stack.push(node.right);
                }
                //左
                if (node.left != null) {
                    stack.push(node.left);
                }



            } else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
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
