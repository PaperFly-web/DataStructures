package stack;

public class Calculator {

    public static void main(String[] args) {
        //用于计算，有多少个连续的数字
        int count=0;
        String temSumNum="";//临时保存数

        String express="13-9/3+4";
        //创建2个栈，数栈和操作符栈
        Stack3 numStack = new Stack3(10);
        Stack3 operStack = new Stack3(10);
        int num1=0;
        int num2=0;
        char ch=' ';
        int res=0;
        int index=0;
        //用来标记前一个符号是否是减号
        boolean flag=false;
        while (true){
            //获取字符串中的值
            ch = express.substring(index, index + 1).charAt(0);
            //判断是字符还是数字
            if(operStack.isOper(ch)){
                //判断前一个符号是否是减号，如果是减号，就入栈为负数
                if (flag){
                    //如果发现是操作符了，就前面临时保存的数入数栈
                    numStack.push(-Integer.valueOf(temSumNum));
                }else {
                    numStack.push(Integer.valueOf(temSumNum));
                }
                //判断是否是减号
                if(operStack.isMinus(ch)){
                    //如果是减号，就把减号变成加号
                    ch='+';
                    //修改标志位，标志这是一个减号，扫描下一个数字的时候，把数字变成负数
                    flag=true;
                }else {
                    flag=false;
                }

                //归空temSumNum
                temSumNum="";


                //判断操作符栈是否为空
                if(!operStack.isEmpty()){
                    int prority1 = operStack.prority(ch);
                    int prority2 = operStack.prority(operStack.peek());

                    //如果小于或等于：就先弹出操作符栈一个操作符
                    // 然后弹出数栈的2个数据，进行运算（tips:后弹出数，运算时候在前）
                    if (prority1<=prority2){
                        int oper = operStack.pop();
                        num1=numStack.pop();
                        num2=numStack.pop();
                        res = numStack.computer(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {//如果大于：就继续入操作符栈
                        operStack.push(ch);
                    }
                }else {//如果为空，就直接入操作符栈
                    operStack.push(ch);
                }

            }else {//不是字符，就是数，先临时保存数的值，防止后面还是数
                temSumNum=temSumNum+ch;
                //numStack.push(ch-48);
            }
            index++;
            if (index>=express.length()){
                //表达式最后一个，肯定是数字，所以最后一次临时保存的数，就没发入栈了，就只能在这里入栈
                numStack.push(Integer.valueOf(temSumNum));
                temSumNum="";
                break;
            }
        }
        //依次pop出数栈和操作符栈
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            int oper = operStack.pop();
            num1=numStack.pop();
            num2=numStack.pop();
            res = numStack.computer(num1, num2, oper);
            numStack.push(res);
        }
        //数栈中最后只有一个数，就是结果
        System.out.println(express+"计算结果："+numStack.pop());
    }
}
class Stack3{


    private int maxSize;
    private  int[] arrStack;
    private int top=-1;
    public Stack3(int maxSize){
        this.maxSize=maxSize;
        arrStack=new int[this.maxSize];
    }

    public boolean isFull(){
        return top==this.maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    //查看栈顶元素值，但不是pop
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈为空，所以查看不到数据======");
        }
        return arrStack[top];
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

    //判断是否是操作符
    public boolean isOper(char ch){


        return ch=='+'||ch=='-'||ch=='*'||ch=='/';

    }

    public boolean isMinus(char ch){
        return ch=='-';
    }
    //判断操作符的优先级
    public int prority(int ch){
        int res=-1;
        switch (ch) {
            case '*':
            case '/':
                res=1;
                break;

            case '-':
            case '+':
                res=0;
                break;
            default:
                res=-1;
        }
        return res;
    }

    //计算值
    public int computer(int num1,int num2,int ch){
        int res=0;
        switch(ch){
            case '+':
                res=num2+num1;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num2*num1;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                System.out.println("没有【"+ch+"】这个操作符，所以不能计算======");
        }
        return res;
    }
}