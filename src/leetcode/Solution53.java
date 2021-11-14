package leetcode;

import java.util.Arrays;

public class Solution53 {

    //暴力法
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int temSum = 0;
            for (int j = i; j < nums.length; j++) {
                temSum += nums[j];
                result = temSum > result ? temSum : result;
            }
        }
        return result;
    }

    //贪心
    public int maxSubArray2(int[] nums) {
        int result = 0;
        int temSum = 0;
        for (int i = 0; i < nums.length; i++) {
            temSum += nums[i];
            if(temSum>=0){
                if(temSum>result){
                    result = temSum;
                }
            }else{
                temSum = 0;
            }
        }
        Arrays.sort(nums);
        return result==0? nums[nums.length-1]:result;
    }
}
