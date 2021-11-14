package leetcode;

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int pre = 0;
        int cur = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i + 1] - nums[i];
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                result++;
                pre = cur;
            }
        }
        return result;
    }
}
