package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution90 {
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        this.backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            this.backTracking(nums, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
