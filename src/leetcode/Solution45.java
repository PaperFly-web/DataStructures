package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution45 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int result = 0;
        for (int i = g.length - 1; i >= 0 && index >= 0; i--) {
            if (s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
