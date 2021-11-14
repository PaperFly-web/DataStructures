package leetcode;

public class Solution700 {

    public TreeNode searchBST(TreeNode root, int val) {
        //1.确定终止条件
        if(root==null||root.val==val){
            return root;
        }
        //2.单层递归逻辑
        if(val<root.val){
            return this.searchBST(root.left,val);
        }
        if(val>root.val){
            return this.searchBST(root.right,val);
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        TreeNode temRoot = root;
        while (temRoot!=null){
            if(temRoot.val==val){
                return temRoot;
            }
            if(val<temRoot.val){
                temRoot=temRoot.left;
                continue;
            }
            if(val>temRoot.val){
                temRoot=temRoot.right;
            }
        }
        return null;

    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
