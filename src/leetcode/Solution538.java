package leetcode;

public class Solution538 {
    int preVal = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        this.convertBST(root.right);
        root.val += preVal;
        preVal = root.val;
        this.convertBST(root.left);
        return root;
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
