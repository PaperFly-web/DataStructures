package search;

import java.util.List;

public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        /*int i = binarySearch(0, arr.length - 1, 1000, arr);
        System.out.println(i);*/
        int index = binarySearch(0, arr.length - 1, 1000, arr);
        System.out.println(index);
    }

    public static int insertValueSearch(int left,int right,int findValue,int [] arr){
        //如果查找的值是一个大于或者小于  数组的最大或者最小值，就或造成下标越界
        //所以这个条件是必须要有的：findValue<arr[0]||findValue>arr[arr.length-1]
        System.out.println("插值查找======");
        if(left>right||findValue<arr[0]||findValue>arr[arr.length-1]){
            return -1;
        }
        //插值查找公式
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        if(findValue>arr[mid]){
            return insertValueSearch(mid+1,right,findValue,arr);
        }else if(findValue<arr[mid]){
            return insertValueSearch(left,mid-1,findValue,arr);
        }else {
            return mid;
        }
    }

    //只能找到一个符合条件的
    public static int binarySearch(int left,int right,int findVale,int []arr){
        System.out.println("二分查找======");
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
}
