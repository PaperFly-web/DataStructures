package leetcode;

/**
 * 669. 修剪二叉搜索树
 */
public class Solution669 {
    //1.确定返回结果与参数：
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val<low){
            return this.trimBST(root.right,low,high);
        }
        if(root.val>high){
            return this.trimBST(root.left,low,high);
        }
        root.left = this.trimBST(root.left,low,high);
        root.right = this.trimBST(root.right,low,high);
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
