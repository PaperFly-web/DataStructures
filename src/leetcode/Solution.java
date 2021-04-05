package leetcode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        ListNode head1;
        ListNode head2;
        ListNode listNode=new ListNode();
        ListNode listNode2=new ListNode();
        head1=listNode;
        head2=listNode2;
        listNode.val=3;
        listNode.next=new ListNode(7);
        listNode2.val=9;
        listNode2.next=new ListNode(2);



        print(head2);
        System.out.println();
        print(head1);
        System.out.println();
        print(addTwoNumbers(head1,head2));
    }
    public static void print(ListNode head){
        ListNode temHead=head;
        while (temHead!=null){
            System.out.printf("%d\t",temHead.val);
            temHead=temHead.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //如果发生进位，就设置为1，没发生就设置为0
        int flag=0;
        ListNode tem1 =l1;
        ListNode tem2 =l2;
        ListNode tem=new ListNode();
        ListNode head=tem;
        int sum=0;
        while (tem1!=null&&tem2!=null){

                sum=tem1.val+tem2.val+flag;
                tem.val=sum%10;
                if(tem1.next!=null&&tem2.next!=null){
                    tem.next = new ListNode();
                    tem=tem.next;
                }


                ///设置flag位
                flag=sum/10;
                tem1=tem1.next;
                tem2=tem2.next;

        }
        while (tem1!=null){
            tem.next = new ListNode();
            tem=tem.next;
            sum=tem1.val+flag;
            tem.val=sum%10;
            tem1=tem1.next;
            flag=sum/10;
        }
        while (tem2!=null){
            tem.next = new ListNode();
            tem=tem.next;

            sum=tem2.val+flag;
            tem.val=sum%10;
            tem2=tem2.next;
            flag=sum/10;
        }
        if(flag!=0){
            tem.next = new ListNode();
            tem=tem.next;
            tem.val=flag;
        }
        return head;
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
