package leetcode;

import java.util.List;

public class Solution2042 {
    public static void main(String[] args) {
        Solution2042 s = new Solution2042();
        System.out.println(s.areNumbersAscending("5 5"));
    }

    public boolean areNumbersAscending(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder temStrNum = new StringBuilder();
        int temVal = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] >= '0' && bytes[i] <= '9') {
                temStrNum.append(bytes[i]);
            }
            if ((bytes[i] == ' ' || i == bytes.length-1) && !temStrNum.toString().equals("")) {
                if (temVal != 0 && Integer.valueOf(temStrNum.toString()) <= temVal) {
                    return false;
                }
                temVal = Integer.valueOf(temStrNum.toString());
                temStrNum = new StringBuilder();
            }
        }
        return true;
    }
}
