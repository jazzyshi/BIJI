package com.jz.bigdata.algorithm;

/**
 * 二分查找
 * 又叫折半查找，要求待查的序列有序
 * 每次取中间位置的值与待查值进行比较：
 * 1.如果中间位置的值碧待查值大，则在前半部分循环这个查找的过程
 * 2.如果中间位置的值比待查值小，则在后半部分循环这个查找的过程
 * 3.知道查到这个值，否在序列中没有这个值
 */
public class EeFenSearch {
    public static int doSearch(int[] array,int a) {
        int low = 0;
        int high = array.length - 1;
        int mid ;
        while (low <= high) {
            mid = (low + high)/2;
            if (a == array[mid]){
               return mid;
            }else if(a < array[mid]){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(doSearch(new int[]{1,2,3,4,5,6,7,8},6));
    }
}
