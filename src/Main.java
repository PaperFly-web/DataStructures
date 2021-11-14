import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public int[] mergeSortedArray(int[] a, int m, int[] b, int n) {
        int i = 0, j = 0;
        while (i < a.length && j + 1 < n) {
            int tem;
            if (i >= m) {
                tem = b[j];
                if (tem < b[j + 1]) {
                    a[i] = b[j];
                } else {
                    a[i] = b[j + 1];
                    b[j + 1] = tem;
                }

                j++;
                i++;
                continue;
            }
            if (a[i] > b[j]) {
                tem = a[i];
                a[i] = b[j];
                b[j] = tem;
                i++;
            } else {
                i++;
            }
        }
        a[i] = b[j];
        return a;
    }
}

public class Main {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine().trim());
        int[] _b = new int[_b_size];
        int _b_item;
        for (int _b_i = 0; _b_i < _b_size; _b_i++) {
            _b_item = Integer.parseInt(in.nextLine().trim());
            _b[_b_i] = _b_item;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = new Solution().mergeSortedArray(_a, _m, _b, _n);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }*/


    public static void main(String[] args) {
        test("baAcbb");

    }

    public static String test(String b){
        Node[] nodes = new Node[52];
        for (byte aByte : b.getBytes()) {
            if(aByte<='Z'){
                if(nodes[aByte-'A']==null){
                    Node node = new Node();
                    node.b=aByte;
                    node.count=1;
                    nodes[aByte-'A']=node;
                }else {
                    nodes[aByte-'A'].count++;
                }
            }else {
                if(nodes[aByte-'a'+26]==null){
                    Node node = new Node();
                    node.b=aByte;
                    node.count=1;
                    nodes[aByte-'a'+26]=node;
                }else {
                    nodes[aByte-'a'+26].count++;
                }
            }
        }


        Arrays.sort(nodes);
        System.out.println("");
        return "";
    }
    static class Node implements Comparable<Node>{
        Byte b;
        Integer count;


        @Override
        public int compareTo(Node o) {
            return -(this.count-o.count);
        }
    }
}
