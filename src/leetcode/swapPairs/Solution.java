package leetcode.swapPairs;

public class Solution {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode head=node1;
        Solution solution = new Solution();
        ListNode swapPairs = solution.swapPairs(head);
    }
    public ListNode swapPairs(ListNode head) {
        //1)如果只有1个节点或者没有节点
        if (head==null||head.next == null) {
            return head;
        }
        ListNode temp = head;
        int size = 0;
        //统计有多少个节点
        while (temp != null) {
            temp=temp.next;
            size++;
        }
        //2）只有2个节点
        if (size == 2) {
            head.next.next = head;
            temp = head.next;
            head.next = null;
            return temp;
        }
        //3）其他情况
        //设置2个变量，为单结点链表头结点和双结点头结点（单/双：结点在链表的位置）
        ListNode front = head;
        ListNode rear = head.next;
        ListNode temFront = front;
        ListNode temRear = rear;
        int temSize = size / 2;
        //拆分链表：奇数为一链表，偶数为一链表
        while (temSize-- != 1) {
            front.next = front.next.next;

            front =front.next;

            rear.next = rear.next.next;
            rear = rear.next;
        }
        front.next=front.next.next==null?null:front.next.next;
        rear.next=null;


        temSize=size/2;
        front=temFront;
        rear=temRear;
        //把奇数和偶数链表交叉连接
        while (temSize--!=1){
            temp=rear.next;
            rear.next=front;
            rear=temp;

            temp=front.next;
            front.next=rear;
            front=temp;
        }
        rear.next=front;
        return temRear;
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