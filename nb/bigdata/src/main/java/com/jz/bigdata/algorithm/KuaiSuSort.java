package com.jz.bigdata.algorithm;

/**
 * 快速排序算法：
 * 选择一个关键值作为基准值，
 * 比基准值小的都在左边序列（一般无序的）
 * 比基准值值大的都在右边（一般是无序的）
 * 一般选择序列的第一个元素(循环时的第一个)
 * 一次循环：
 * 从后往前比较，用基准值和最后一个值比较，如果比基准值小的交换位置，如果没有继续比较下一个（直到找到第一个比基准值小的才交换）
 * 找到这个值会，
 * 从前往回开始比较，如果比基准值大的，才交换位置
 *
 *终点：从前往后的比较索引>从后往前的比较索引，结束第一次循环，这样对于基准值，左右两边就是有序的了
 */
public class KuaiSuSort {
    public static int[] doSort(int[] arrays,int low,int high){
        int start= low;
        int end = high;
        int selectedValue = arrays[low];
        while(end > start) {
            while (end > start &&arrays[end] >= selectedValue) {//从后往前比较
                end--;
                if (arrays[end] <= selectedValue) {
                    int temp = arrays[end];
                    arrays[end] = arrays[start];
                    arrays[start] = temp;
                }
            }
            while (start < end && arrays[start] <= selectedValue) {//从前往后比较
                start++;
                if (arrays[start] >= selectedValue) {
                    int temp = arrays[start];
                    arrays[start] = arrays[end];
                    arrays[end] = temp;
                }
            }
       }
        //递归
        if(start > low ) doSort(arrays,low,start -1);
        if(end < high ) doSort(arrays,end+1,high);
        return  arrays;
    }

    public static void main(String[] args) {
        int[] aa = doSort(new int[]{10, 76, 19, 88, 8,99,16,17,87,1},0,9);
        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }
    }
}
