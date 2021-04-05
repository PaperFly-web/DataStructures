package stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack(20);
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.push(4);
//        linkStack.showStack();
        System.out.println(linkStack.pop());
        System.out.println("栈中的数据是======");
        linkStack.showStack();
    }

}
class LinkStack{
    private int maxSize;
    private Stack2 next;
    private Stack2 head;
    public LinkStack(int maxSize){
        this.maxSize=maxSize;
        head=new Stack2(0);
    }
    //判断栈是否满
    public boolean isFull(){
        int count=0;
        Stack2 temHead=head;
        //循环遍历，链表有效的数据
        while (temHead.next!=null){
            count++;
            temHead=temHead.next;
        }
        if (count==maxSize){
            return true;
        }else {
            return false;
        }
    }

    //添加数据到栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满了，不能添加数据了======");
        }
        Stack2 temHead=head;
        while (temHead.next!=null){
            temHead=temHead.next;
        }
        Stack2 stack2 = new Stack2(value);
        temHead.next=stack2;

    }
    //弹栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空======");
        }
        //如果栈中只有一个是数据，就直接弹栈
        if (head.next.next==null){
            int value=head.next.value;
            head.next=null;
            return value;
        }
        //能到这里，栈中肯定至少有2个数据了
        Stack2 temHead=head.next;
        while (temHead.next.next!=null){//这里如果退出，说明找到要弹出栈的前一个数据。找前一个数据主要是为了好吧最后一个数据置为空
            temHead=temHead.next;
        }
        int value=temHead.next.value;
        temHead.next=null;
        return value;
    }

    //输出栈的数据，相当于逆序输出链表的数据
    public void showStack(){
        LinkStack linkStack=new LinkStack(this.maxSize);
        Stack2 temHead=head.next;
        while (temHead!=null){
            linkStack.push(temHead.value);
            temHead=temHead.next;
        }
        while (!linkStack.isEmpty()){
            System.out.println(linkStack.pop());
        }
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return head.next==null;
    }
}
class Stack2{
    int value;
    Stack2 next;
    public Stack2(int value){
        this.value=value;
    }
}
