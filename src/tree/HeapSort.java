package tree;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int arr[]=new int[8000000];
        Random random = new Random();
        for (int i=0;i<8000000;i++){
            arr[i]= random.nextInt(8000000);
        }
        //System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
        heapSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);


//        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int arr[]){
        int temp;
        //先把堆，调整成大顶堆
        //最后一个非叶子节点：arr.length/2-1
        for (int i=arr.length/2-1;i>=0;i--){
            adjust(arr,i,arr.length);
        }
        //将堆顶元素，和堆末尾元素进行交换
        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            //交换完一次后，在把交换后的堆进行堆调整
            //解释这里为什么，非叶子节点下标永远是0
            //在进行交换之前，这个堆肯定已经是大顶堆了，交换完成后，唯一不可能是大顶堆的非叶子节点，就只能是堆顶元素了
            //数组长度为甚是j?:没交换一次，length就是减一，刚好和j相同
            adjust(arr,0,j);
        }
    }

    /**
     *@desc:完成 将 以 i 对应的非叶子结点的树调整成大顶堆（注意不是整个树，是以i为非叶子节点的树，调整成大顶堆）
     *@param:[arr:表示要调整的数组, i：非叶子节点的索引, length：还有多少要调整的数据]
     *@return:void
     *@author:paperfly
     *@time:2021/3/31 20:07
     */
    public static void adjust(int arr[],int i,int length){
        //先把当前非叶子节点临时保存起来
        int temp=arr[i];
        //查看当前非叶子节点的左右子节点，大不大于它
        //2*i+1:表示是i的左子结点的下标
        //k=k*2+1：这个是防止交换后，子结点又不满足了大顶堆了，所以进行循环到下一个非叶子节点
        for (int k=2*i+1;k<length;k=k*2+1){
            //k+1：表示右子节点
            //先比较左右子节点哪个大
            if(k+1<length&&arr[k]<arr[k+1]){
                //如果右子子节点大于左子节点，就让k+1，指向右子节点
                k++;
            }
            //和非叶子结点进行比较
            if(arr[k]>temp){
                arr[i]=arr[k];
                //记住交换的位置，最后要把非叶子结点的数据交换回去
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }


    public static void heapSort2(int arr[]){
        int tem;
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int i=arr.length-1;i>0;i--){
            tem=arr[i];
            arr[i]=arr[0];
            arr[0]=tem;
            adjustHeap(arr,0,i);
        }
    }
    public static void adjustHeap(int arr[],int i,int length){
        int tem=arr[i];
        for (int j=2*i+1;j<length;j=j*2+1){
            if(j+1<length&&arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j]>tem){
                arr[i]=arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i]=tem;
    }
}
