package leetcode;

import java.util.*;
import java.util.stream.*;


public class Solution40 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;
    private Integer temSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);

        this.backTracking(candidates, target, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int startIndex) {
        if (temSum > target) {
            return;
        }
        if (temSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[(i - 1)]) {
                continue;
            }
            temSum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            this.backTracking(candidates, target, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
            temSum -= candidates[i];
        }

    }
}
