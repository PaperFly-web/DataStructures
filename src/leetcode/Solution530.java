package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        inorder(root,resList);//得到的resList就是一个升序的集合
        int min = resList.get(1)-resList.get(0);
        //找出最小的差
        for (int i = 1; i < resList.size()-1; i++) {
            min = Math.min(min,resList.get(i+1)-resList.get(i));
        }
        return min;
    }
    //利用中序遍历二叉搜索树为升序特性
    public void inorder(TreeNode root, List<Integer> res){
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
