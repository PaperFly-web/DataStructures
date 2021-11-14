package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int temN = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.backTracking(k, n, 0);
        return res;
    }

    private void backTracking(int k, int n, int startIndex) {
        if (path.size() == k && temN == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < 9; i++) {
            if (path.size() > k || temN + i + 1 > n) {
                continue;
            }
            temN += i + 1;
            path.add(i + 1);
            this.backTracking(k, n, i + 1);
            temN -= i + 1;
            path.remove(path.size() - 1);
        }
    }
}
