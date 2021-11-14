package leetcode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return this.sorted(nums,0,nums.length-1);
    }

    public TreeNode sorted(int[] nums,int left, int right){
        //1.确定终止条件
        if(left>right){
            return null;
        }
        //2.单层处理逻辑
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = this.sorted(nums,left,mid-1);
        root.right = this.sorted(nums,mid+1,right);
        //3.最终返回值
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
