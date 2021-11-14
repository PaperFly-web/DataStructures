package leetcode;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            int index = (i + 1) % cost.length;
            while (rest > 0 && index != i) {
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            if (rest >= 0 && index == i) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int rest[] = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
        }
        int index = 0;
        int sum = 0;
        int totalSum = 0;
        for (int i = 0; i < rest.length; i++) {
            sum += rest[i];
            totalSum += rest[i];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
        }
        if(totalSum<0){
            return -1;
        }
        return index;
    }
}
