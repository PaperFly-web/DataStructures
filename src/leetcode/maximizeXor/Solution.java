package leetcode.maximizeXor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(divide(10, -3));
    }
    public static int divide(int dividend, int divisor) {
        if (divisor==1){
            return dividend;
        }else if(divisor==-1){
            return -dividend;
        }
        if(dividend==divisor){
            return 1;
        }
        boolean flag=true;//判断正负
        long tem=0;
        int sum=0;
        if ((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
            flag=false;
        }
        if(dividend<0){
            dividend=-dividend;
        }
        if (divisor<0){
            divisor=-divisor;
        }

        while (true){
            tem=tem+divisor;
            if (tem>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(tem>dividend){
                break;
            }
            sum++;
        }
        return flag?(int)sum:-(int)sum;
    }


}