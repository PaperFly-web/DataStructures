package leetcode.delLastNNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(head,n)==n?head.next:head;
    }

    public int removeNode(ListNode node,int n){
        if(node.next==null){
            return 1;
        }
        int m=removeNode(node.next,n);
        if (n==m){
            if (m==1){
                node.next=null;
            }else {
                node.next=node.next.next;
            }
        }
        return m+1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}