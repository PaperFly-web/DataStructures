package leetcode;

public class Solution55 {

    public static void main(String[] args) {
        int param[] = {3, 2, 1, 0, 4};
//        int param[] = {1,1,0,1};
        Solution55 s = new Solution55();
        System.out.println(s.canJump2(param));
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int jumNum = nums[0];
        if(jumNum==0){
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            jumNum--;
            if (nums[i] >= jumNum) {
                jumNum = nums[i];
            }
            if (jumNum < 0 ||(jumNum==0 && i!=nums.length-1)) {
                return false;
            }
        }
        return true;
    }


    public boolean canJump2(int[] nums) {
        int jumNum = 0;
        for (int i = 0; i < nums.length; i++) {
            jumNum--;
            if (nums[i] >= jumNum) {
                jumNum = nums[i];
            }
            if (jumNum < 0 ||(jumNum==0 && i!=nums.length-1)) {
                return false;
            }
        }
        return true;
    }
}
