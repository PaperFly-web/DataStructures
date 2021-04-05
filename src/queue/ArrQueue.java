package queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

public class ArrQueue {




    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;

    //数组队列构造器
    public ArrQueue(int maxSize){
        this.maxSize=maxSize;
        front=-1;
        rear=-1;
        queue=new int[this.maxSize];
    }

    //获取队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //获取队列是否满了
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //添加数据到队列
    public void addQueue(int n){
        //首先判断队列是否已经满了
        if (isFull()){
            throw new RuntimeException("队列已经满了，不能在添加数据了======");
        }

        queue[++rear]=n;
    }

    //队列数据出队列
    public int getQueue(){
        //首先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列没有数据了======");
        }
        return queue[++front];
    }

    //打印出队列的所有数据
    public void showQueue(){
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("a[%d]=%d\n",i,queue[i]);
        }
    }

    //获取队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列为空=====");
        }
        return queue[front+1];
    }
}
