package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]=new int[8000000];
        Random random = new Random();
        for (int i=0;i<8000000;i++){
            arr[i]= random.nextInt(8000000);
        }

        //System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
//        quickSort();
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        //System.out.println(Arrays.toString(arr));
//        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        //insertSort2(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[]){
        for (int i=arr.length-1;i>0;i--){
            //如果在一趟排序比较过程中，一次交换都没有发生过，就可以直接退出了
            boolean flag=false;
            for (int j=0;j<i;j++){
                int tem;

                if (arr[j]>arr[j+1]){
                    flag=true;

                    tem=arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=tem;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static void choiceSort(int arr[]){
        //依次寻找最大的
        for (int i=arr.length-1;i>0;i--){
            //临时记住最大的数组下标
            int temIndex=i;
            for (int j=0;j<i;j++){
                if (arr[j]>arr[temIndex]){
                    temIndex=j;
                }
            }
            int tem;
            tem=arr[i];
            arr[i]=arr[temIndex];
            arr[temIndex]=tem;
        }

    }




    //这个相当于，把一个数组看做俩份，前面一份是已经排序好的，后面部分是乱序的
    public static void insertSort(int arr[]){
        if (arr.length==0||arr.length==1){
            return;
        }
        //已经排序好的长度
        int sortedLength=1;
        int tem;

        for (int i=1;i<arr.length;i++){
            tem=arr[i];
            //如果发现比已经排好的最大都大，那么就不用改变了
            if (tem>=arr[i-1]){
                sortedLength++;
                continue;
            }
            for (int j=0;j<sortedLength;j++){
                //比当前数据小，就说明后面的数据都tem大
                if (tem<arr[j]){
                    //后面的数据全部后移一位
                    for (int t=sortedLength;t>j;t--){
                        arr[t]=arr[t-1];
                    }
                    //把tem放到当前的位置中
                    arr[j]=tem;
                    break;
                }
            }

            sortedLength++;
        }

    }



    //希尔排序
    public static void shellSort(int arr[]){
        for (int gap=arr.length/2;gap>0;gap/=2){
            //i从  gap开始，就相当于前一个数据是默认被排序好的
            for (int i=gap;i<arr.length;i++){
                //临时保存当前取的数据信息
                int j=i;
                int tem=arr[j];
                //如果比排序好的最大的还大，就不用调整了
                //一但找到比最大的还小，就可以进入循环体，精确的寻找插入到哪个位置
                if (arr[j]<arr[j-gap]){
                    //然后和其他剩余的值进行比较，比他小的都往后移
                    while (j-gap>=0&&tem<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                }
                //当退出循环后，就是已经找到了要插入的位置
                arr[j]=tem;
            }
        }
    }






    public static void shellSort2(int arr[]){
        //可以进行分组几次
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                int j=i;
                //取出一个数据，和已排序好的进行比较
                int tem=arr[j];
                //只能和组内的数据进行比较
                //只有比组内最大的还小，才能进行进一步的比较，不然就不用动
                if(tem<arr[j-gap]){
                    arr[j]=arr[j-gap];
                    j-=gap;
                    while (j-gap>=0&&arr[j-gap]>tem){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                }else {
                    continue;
                }
                arr[j]=tem;
            }
        }
    }


    public static void shellSort3(int arr[]){
        //对数组按照  2增量进行分组
        for (int gap=arr.length/2;gap>0;gap/=2){
            //i从gap开始，就是为了默认第一个数据是已经排序好的了
            for (int i=gap;i<arr.length;i++){
                //取出乱序中的第一个数据
                int j=i;
                int tem=arr[j];
                //用乱序的和已经排序好的进行比较
                //tem<arr[j-gap]：如果比排序好的最大的还大，就不用动了
                if(tem<arr[j-gap]){
                    //和剩余排序好的进行比较
                    while (j-gap>=0&&arr[j-gap]>tem){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                }
                //执行到这里，就说明已经找到要插入的位置了
                arr[j]=tem;
            }
        }
    }

    //快速排序
    public static void quickSort(int left,int right,int arr[]){
        //最后的递归调用退出条件：如果只剩下一个数据了，那么left==right说明可以退出了
        if(left>=right){
            return;
        }
        int l,r,base;
        l=left;
        r=right;
        base=arr[left];
        while (l<r){
            //在右边，找到比base小的下标
            while (l<r){
                if(arr[r]<base){
                    arr[l]=arr[r];
                    //交换完r后，把l加1
                    l++;
                    break;
                }
                r--;
            }
            //在左边，找到比base大的
            while (l<r){
                if(arr[l]>base){
                    arr[r]=arr[l];
                    //交换完成l后，把r的加1
                    r--;
                    break;
                }
                l++;
            }
        }
        //把基数放到中间
        arr[l]=base;
        quickSort(left,l-1,arr);
        quickSort(l+1,right,arr);
    }

    //归并排序
    public static void mergeSort(int low,int hight,int arr[]){
        int mid=(low+hight)/2;
        //如果左边指针还比右边小，那么就还可以进行分组下去
        if(low<hight){
            //先进行左边下一级的左边分组
            mergeSort(low,mid,arr);
            //在进行下一级的右边分组
            mergeSort(mid+1,hight,arr);
            //所有分组完毕后，进行合并，也就是分治的治
            merg(low,hight,mid,arr);
        }
    }
    //进行合并
    public static void merg(int low,int hight,int mid,int[]arr){

        //创建临时数组，保存数据
        int []temp=new int[hight-low+1];
        //创建变量，i,j用来比较俩组数据的大小
        // p用来作为temp数组的下标
        int i,j,p;
        i=low;
        j=mid+1;
        p=0;
        //合并2个组的数据，合并之后是一个有序的
        while (i<=mid&&j<=hight){
            if(arr[i]<arr[j]){
                temp[p++]=arr[i++];
            }else {
                temp[p++]=arr[j++];
            }
        }
        //如果小组中还有剩余的，就直接全部赋值到temp中
        while (i<=mid){
            temp[p++]=arr[i++];
        }
        while (j<=hight){
            temp[p++]=arr[j++];
        }
        //把临时数据中的数据，在覆盖到原生数组中
        for (i=0;i<temp.length;i++){
            arr[low+i]=temp[i];
        }
    }

    public static void merg2(int low,int hight,int mid,int[]arr){
        if (low>=hight){
            return;
        }
        int tem[]=new int[hight-low+1];
        int i,j,base,p=0;
        i=low;j=mid+1;
        base=arr[low];
        while (i<=mid&&j<=hight){
            if (arr[j]<base){
                tem[p++]=arr[j++];
            }else {
                tem[p++]=arr[i++];
            }
        }
        while (i<=mid){
            tem[p++]=arr[i++];
        }
        while (j<=hight){
            tem[p++]=arr[j++];
        }
        for (int k = 0; k <tem.length ; k++) {
            arr[low+k]=tem[k];
        }
    }


    public static void mergeSort2(int low,int higth,int[]arr){
        int mid=(higth+low)/2;
        if(low<higth){
            mergeSort2(low,mid,arr);
            mergeSort2(mid+1,higth,arr);
            merg2(low,higth,mid,arr);
        }
    }


    //基数排序
    public static void radixSort(int[]arr){
        //寻找最大的值
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        //最大数的长度
        int maxLength=(max+"").length();
        //创建10个桶，用来装数据
        int buckets[][]=new int[10][arr.length];
        //保存每个桶中的有效数据个数
        int bucketLength[]=new int[10];
        int k=0,div=1;
        for (int t=1;t<=maxLength;t++){
            for (int i=0;i<arr.length;i++){
                //放到第几个桶
                k=arr[i]/div%10;
                //放在这个桶中的第几个位置
                buckets[k][bucketLength[k]++]=arr[i];
            }
            int index=0;
            for (int i = 0; i <buckets.length ; i++) {
                for (int j = 0; j < bucketLength[i]; j++) {
                    arr[index++]=buckets[i][j];
                }
                //把每个桶存储数据的个数置为0
                bucketLength[i]=0;
            }

            div=div*10;
        }

    }
}
