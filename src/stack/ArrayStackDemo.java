package stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(20);
        stack.showStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.showStack();
    }
}

class Stack{
    private int maxSize;
    private  int[] arrStack;
    private int top=-1;
    public Stack(int maxSize){
        this.maxSize=maxSize;
        arrStack=new int[this.maxSize];
    }

    public boolean isFull(){
        return top==this.maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈已满======");
            return;
        }
        arrStack[++top]=value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈是空的======");
        }
        return arrStack[top--];
    }

    public void showStack(){
        if (isEmpty()){
            System.out.println("栈是空的======");
            return;
        }
        int temTop=top;
        while (temTop!=-1){
            System.out.println(arrStack[temTop--]);
        }
    }
}
