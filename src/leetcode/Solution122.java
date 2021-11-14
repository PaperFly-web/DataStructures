package leetcode;

public class Solution122 {
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 0; i < prices.length-1; i++) {
                result += Math.max(prices[i+1]-prices[i],0);
            }
            return result;
        }
}
