package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution860 {
    public static void main(String[] args) {
        int param[] = {5,5,5,10,5,5,10,20,20,20};
        Solution860 s = new Solution860();
        System.out.println(s.lemonadeChange(param));
    }
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> money = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            Integer money5 = 0;
            Integer money10 = 0;
            switch (bills[i]) {
                case 5:
                    money.put(5, money.getOrDefault(5, 0) + 1);
                    break;
                case 10:
                    money5 = money.get(5);
                    if (money5 == null || money5 <= 0) {
                        return false;
                    } else {
                        money.put(5, money.getOrDefault(5, 0) - 1);
                    }
                    money.put(10, money.getOrDefault(10, 0) + 1);
                    break;
                case 20:
                    money10 = money.get(10)==null?0:money.get(10);
                    money5 = money.get(5)==null?0:money.get(5);
                    if (money10 >= 1 && money5 >= 1) {
                        money.put(10, money.getOrDefault(10, 0) - 1);
                        money.put(5, money.getOrDefault(5, 0) - 1);
                    }else if(money10 <=0 && money5 >= 3){
                        money.put(5, money.getOrDefault(5, 0) - 3);
                    }else {
                        return false;
                    }
                    money.put(20, money.getOrDefault(20, 0) + 1);
                    break;
                default:
            }
        }
        return true;
    }
}
