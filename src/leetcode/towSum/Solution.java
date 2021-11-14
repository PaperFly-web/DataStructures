package leetcode.towSum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] sum=new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i=0;i<nums.length;i++){
            //判断之前是否有与我相加  等于  target的
            if(hashMap.containsKey(nums[i])){
                sum[0]=hashMap.get(nums[i]);
                sum[1]=i;
                return sum;
            }
            hashMap.put(target-nums[i],i);
        }
        /*for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    sum[0]=i;
                    sum[1]=j;
                    return sum;
                }
            }
        }*/
        return null;
    }

}