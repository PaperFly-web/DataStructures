package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution491 {
    public static void main(String[] args) {
        Solution491 s = new Solution491();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};
        System.out.println(s.findSubsequences(nums));
    }

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        if (startIndex >= nums.length) {
            return;
        }
        //每一层，去重
        Set<Integer> uset = new TreeSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if ((path.size() > 0 && nums[i] < path.get(path.size() - 1)) || uset.contains(nums[i])) {
                continue;
            }
            uset.add(nums[i]);
            path.add(nums[i]);
            this.backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
