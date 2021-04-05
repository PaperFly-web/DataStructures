package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        /*int i = binarySearch(0, arr.length - 1, 1000, arr);
        System.out.println(i);*/
        List<Integer> list = binarySearch2(0, arr.length - 1, 1000, arr);
        System.out.println(list);

    }

    //只能找到一个符合条件的
    public static int binarySearch(int left,int right,int findVale,int []arr){

        //这个判断找不到  退出的条件，就不用多想一步最后left  right相等的条件
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if(findVale>arr[mid]){
            return binarySearch(mid+1,right,findVale,arr);
        }else if(findVale<arr[mid]){
            return binarySearch(left,mid-1,findVale,arr);
        }else {
            return mid;
        }
    }


    //如果有多个符合条件的，都找出来
    public static List<Integer> binarySearch2(int left, int right, int findVale, int []arr){
        //这个判断找不到  退出的条件，就不用多想一步最后left  right相等的条件
        if(left>right){
            return new ArrayList();
        }
        int mid=(left+right)/2;
        if(findVale>arr[mid]){
            return binarySearch2(mid+1,right,findVale,arr);
        }else if(findVale<arr[mid]){
            return binarySearch2(left,mid-1,findVale,arr);
        }else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int tem=mid-1;
            //向左循环，找一找还有没有和他相同的
            while (true){
                if(tem<0||arr[tem]!=findVale){
                    break;
                }
                resIndexList.add(tem);
                tem--;
            }
            //把中间这个找到的添加到集合中
            resIndexList.add(mid);
            //向右循环，找一找还有没有和他相同的
            tem=mid+1;
            while (true){
                if(tem>arr.length-1||arr[tem]!=findVale){
                    break;
                }
                resIndexList.add(tem);
                tem++;
            }
            return resIndexList;
        }
    }
}
