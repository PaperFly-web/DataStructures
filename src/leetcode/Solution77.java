package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public static void main(String[] args) {
        Solution77 s = new Solution77();
        s.combine(4,2);
    }
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i=1;i<=n;i++){
            nums[i-1]=i;
        }
        this.backTracking(nums,k,0);
        return res;
    }



    public void backTracking(int[] nums, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(path.size()+nums.length-startIndex<k){
                continue;
            }
            path.add(nums[i]);
            this.backTracking(nums,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
