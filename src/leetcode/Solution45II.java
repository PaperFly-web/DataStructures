package leetcode;

public class Solution45II {
    public static void main(String[] args) {
        Solution45II s = new Solution45II();
        int param[] = {2, 3, 1, 1, 4};
        System.out.println(s.jump(param));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int result = 0;
        int nextDistance = 0;
        int curDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //记录的不是距离，是下一次可以最远到的索引下标
            nextDistance = Math.max(nums[i] + i, nextDistance);
            //如果走到了下一次最远的索引下标
            if (i == curDistance) {
                //如果没有走到头
                if (curDistance != nums.length - 1) {
                    result++;
                    curDistance = nextDistance;
                    //替换下一次最远可以到达的索引下标。然后再次判断是不是可以直接到达最后一位
                    if (nextDistance >= nums.length - 1) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
