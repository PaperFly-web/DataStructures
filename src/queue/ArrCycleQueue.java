package queue;

public class ArrCycleQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;

    //数组队列构造器
    public ArrCycleQueue(int maxSize){
        this.maxSize=maxSize;
        front=0;
        rear=0;
        queue=new int[this.maxSize];
    }

    //获取队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //获取队列是否满了
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //首先判断队列是否已经满了
        if (isFull()){
            System.out.println("队列已经满了，不能在添加数据了======");
            return;
        }
        queue[rear]=n;
        rear=(rear+1)%maxSize;
    }

    //队列数据出队列
    public int getQueue(){
        //首先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列没有数据了======");
        }
        int tem= queue[front];
        front=(front+1)%maxSize;
        return tem;
    }

    //打印出队列的所有数据
    public void showQueue(){
        for (int i = front; i < front+size(); i++) {
            System.out.printf("a[%d]=%d\n",i%maxSize,queue[i%maxSize]);
        }
    }

    //获取队列有效个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //获取队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列为空=====");
        }

        return queue[front%maxSize];
    }
}
