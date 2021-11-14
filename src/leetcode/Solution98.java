package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    public static void main(String[] args) {
        Solution98 s = new Solution98();
        TreeNode t = new TreeNode(2);
        t.left=new TreeNode(2);
        t.right = new TreeNode(2);
        System.out.println(s.isValidBST(t));
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root,res);
        for (int i = 0; i < res.size()-1; i++) {
            if(res.get(i)>=res.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    static class TreeNode {
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
