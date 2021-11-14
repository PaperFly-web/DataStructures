package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution406 {
    public static void main(String[] args) {
        Solution406 s = new Solution406();
        int param[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        s.reconstructQueue(param);
    }
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> peopleSorted = Arrays.stream(people).sorted((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return -(o1[0] - o2[0]);
            } else {
                return o1[1] - o2[1];
            }
        }).collect(Collectors.toList());
        LinkedList<int[]> queue = new LinkedList<>();
        peopleSorted.forEach(x->{
            queue.add(x[1],x);
        });
        return queue.toArray(new int[people.length][]);
    }
}
