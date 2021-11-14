package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args) {
        Solution17 s = new Solution17();
        System.out.println(s.letterCombinations("23"));
    }
    private List<String> res = new ArrayList<>();
    private StringBuilder path =new StringBuilder();
    public static List<char[]> chars = new ArrayList<>();

    static {
        chars.add(new char[0]);
        char[] ch = {'a','b','c'};
        chars.add(ch);
        char[] ch2 = {'d','e','f'};
        chars.add(ch2);
        char[] ch3 = {'g','h','i'};
        chars.add(ch3);
        char[] ch4 = {'j','k','l'};
        chars.add(ch4);
        char[] ch5 = {'m','n','o'};
        chars.add(ch5);
        char[] ch6 = {'p','q','r','s'};
        chars.add(ch6);
        char[] ch7 = {'t','u','v'};
        chars.add(ch7);
        char[] ch8 = {'w','x','y','z'};
        chars.add(ch8);
    }

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return new ArrayList<>();
        }
        List<char[]> charList = new ArrayList<>();
        byte[] bytes = digits.getBytes();
        for (byte aByte : bytes) {
            charList.add(chars.get(aByte-48-1));
        }
        this.backTracking(charList,0);
        return res;
    }


    private void backTracking(List<char[]> charList,int currentNum){
        if(path.length()==charList.size()){
            res.add(path.toString());
            return;
        }
        if(currentNum>=charList.size()){
            return;
        }
        for (int i =0; i<charList.get(currentNum).length;i++){
            path.append(charList.get(currentNum)[i]);
            this.backTracking(charList,currentNum+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
