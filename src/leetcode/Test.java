package leetcode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Test {




    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        /*
        int [] a={2,2,3,3,4,5};
        System.out.println(test.maxGroupNumber(a));*/
        System.out.println(test.solve("11", "99"));
    }
    public String solve (String s, String t) {
        // write code here
        return (toInteger(s)*toInteger(t))+"";
    }

    public Integer toInteger(String num){
        return Integer.valueOf(num);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * maxGroupNumber
     *
     * @param tiles int整型一维数组 tiles
     * @return int整型
     */
    public int maxGroupNumber(int[] tiles) {
        if (tiles.length < 3) {
            return 0;
        }
        //1.先排序
        Arrays.sort(tiles);
        List<Integer> list = new ArrayList<>();
        for (int tile : tiles) {
            list.add(tile);
        }




        // write code here
        //2、求出第一种情况
        int count = 0;
        for (int i = 0; i < tiles.length - tiles.length % 3; ) {
            if(i + 1 == tiles.length - tiles.length % 3){
                break;
            }
            int one = tiles[i];
            int two = tiles[i + 1];
            int three = tiles[i + 2];
            if (judge(one, two, three)) {
                count++;
            }else {
                i ++;
                continue;
            }
            i+=3;
        }
        return count;

    }

    public boolean judge(int one, int two, int three) {

        if (one == three && one == two) {
            return true;
        } else if (one + 1 == two && two + 1 == three) {
            return true;
        }
        return false;
    }
}
