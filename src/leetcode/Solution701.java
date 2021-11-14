package leetcode;

public class Solution701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        this.insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {

        if (root.left == null && root.val > val) {
            root.left = new TreeNode(val);
            return;
        }
        if (root.right == null && root.val < val) {
            root.right = new TreeNode(val);
            return;
        }
        if (root.val > val) {
            this.insert(root.left, val);
        }
        if (root.val < val) {
            this.insert(root.right, val);
        }
    }

    public class TreeNode {
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
