package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 自己的测试排序
 */
public class TestSort {

    public static void main(String[] args) {
        int arr[]=new int[8];
        Random random = new Random();
        for (int i=0;i<8;i++){
            arr[i]= random.nextInt(80);
        }
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        //1)如果数据长度小于等于1，就不必排序了
        if(arr.length==0||arr.length==1){
            return;
        }

        //已经排序好的数组长度
        int sortedLength=1;
        int tem;
        for (int i=1;i<arr.length-1;i++){
            //如果数组当前的值，比已经排序好的最大还大，就不用动了
            if(arr[i]>=arr[sortedLength-1]){
                sortedLength++;
                continue;
            }
            //找出要插入的位置
            int j=0;
            for ( j=0;j<sortedLength;j++){
                if(arr[i]<=arr[j]){
                    break;
                }
            }
            tem=arr[i];
            //后面的数据全部后移
            for (int t=sortedLength;t>j;t--){
                arr[t]=arr[t-1];
            }
            arr[j]=tem;
            sortedLength++;


        }
    }
}
