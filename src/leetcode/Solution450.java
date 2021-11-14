package leetcode;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return this.delete(root, key);
    }

    private TreeNode delete(TreeNode root, int key) {
        //1.确定终止条件
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //1.左子树为空
            if (root.left == null) {
                return root.right;
            }
            //2.右子树为空
            if (root.right == null) {
                return root.left;
            }
            //3.左右子树都不为空
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = root.left;
            return root.right;
        }
        //2.单层递归逻辑
        if (root.val > key) {
            root.left = this.delete(root.left, key);
        }
        if (root.val < key) {
            root.right = this.delete(root.right, key);
        }
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
