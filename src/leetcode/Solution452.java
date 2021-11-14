package leetcode;

import java.util.Arrays;

public class Solution452 {


    public static void main(String[] args) {
        Solution452 s = new Solution452();
        int[][] param = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] param2 = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int[][] param3 = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(s.findMinArrowShots(param3));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            return o1[0] < o2[0] ? -1 : 1;
        });
        int index = 0;
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > points[index][1]) {
                result++;
                index = i;
            } else {
                index = points[index][1] > points[i][1] ? i : index;
            }
        }
        return result;
    }
}
