package leetcode;

public class Solution135 {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int candys[] = new int[ratings.length];
        candys[0] = 1;
        //1.判断右边大于左边的情况
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candys[i + 1] = candys[i] + 1;
            } else {
                candys[i + 1] = 1;
            }
        }
        int totalSum = 0;
        //2.判断左边大于右边的情况
        for (int i = ratings.length - 1; i > 0; i--) {
            //如果左边大于右边，和之前的值进行比较，推举出一个更大的值
            if (ratings[i - 1] > ratings[i]) {
                candys[i - 1] = Math.max(candys[i] + 1,candys[i-1]);
            }
            totalSum += candys[i];
        }
        totalSum += candys[0];
        return totalSum;
    }
}
