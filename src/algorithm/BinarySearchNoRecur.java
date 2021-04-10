package algorithm;

/**
 * 二分查找算法，非递归实现
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int arr[]={1,2,5,10,25,62,100,159};
        int index = binarySearch(arr, 0);
        System.out.println(index);
    }

    /**
     * 二分查找，非递归实现
     * @param arr  待查找的数组
     * @param target 要查找的值
     * @return 如果找到就返回对应的下标，没找到返回-1
     */
    public static int binarySearch(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int mid;
        while (left<=right){
            //找到数组中间值
            mid=(left+right)/2;
            //如果相等就直接返回
            if (arr[mid]==target){
                return mid;
            } else if(target<arr[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}
