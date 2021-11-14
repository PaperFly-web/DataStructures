package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        this.backTracking(nums);
        return res;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //从同一层作为切入点来看，如果和前面一个数相同，而且我和前面的那个数是同层关系，那么在加入我的话，就是相当于重复执行前面一个数据
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            //从当前组合作为去切入点来看，如果当前已经被加入path中，再加入的话，那就是重复用同一个元素了
            if(used[i]==false){
                used[i] = true;
                path.add(nums[i]);
                this.backTracking(nums);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }
}
