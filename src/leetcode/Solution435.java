package leetcode;

import java.util.Arrays;

public class Solution435 {
    public static void main(String[] args) {
        Solution435 s = new Solution435();
        int param[][] = { {1,2}, {1,2}, {1,2} };
        System.out.println(s.eraseOverlapIntervals(param));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int index = 0;
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[index][1]) {
                result++;
                index = intervals[i][1] > intervals[index][1] ? index : i;
            }else {
                index = i;
            }
        }
        return result;
    }
}
