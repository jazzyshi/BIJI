package com.jz.bigdata.algorithm;

import java.util.Collections;

/**
 * 归并排序算法：
 * 将两个或两个往上的有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。
 * 然后再把有序子序列合并为整体有序序列
 */
public class GuiBingSort {

    public static int[] doSort(int[] data,int left,int right){

        if(left >= right){
            return data;
        }
        //找出中间索引
        int center = (left + right)/2;
        //对左边数组进行递归
        doSort(data,left,center);
        //对右边数组进行递归
        doSort(data,center+1,right);
        //合并
        merge(data,left,center,right);

        return data;
    }

    /**
     * 将两个数组进行合并，归并前两个数组已有序，归并后依然有序
     * @param data 数组对象
     * @param left 左数组第一个元素的索引
     * @param center 左数组最后一个元素的索引，center+1右数组第一个元素的索引
     * @param right
     */
    private static void merge(int[] data, int left, int center, int right) {
        //临时数组
        int[] tmpArr = new int[data.length];
        //右数组第一个元素索引
        int mid = center + 1;
        //third记录临时数组的索引
        int third = left;
        //缓存左数组第一个元素的索引
        int temp = left;
        while(left <= center && mid <= right){
            //从两个数组中取出最小的放入临时数组
            if(data[left] <= data[mid]){
                tmpArr[third++] = data[left++];
            }else{
                tmpArr[third++] = data[mid ++];
            }
        }

        //将剩余部分依次放入临时数组（实际上两个while只执行其中一个）
        while (mid <= right){
            tmpArr[third++] = data[mid++];
        }
        while(left <= center){
            tmpArr[third++] = data[left++];
        }
        //将临时数组中的内容拷贝回原数组中（原left-righr范围的内容被复制回原数组）
        while(temp <= right){
            data[temp] = tmpArr[temp++];
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{76, 10, 19, 88,55,32};
        int[] b = doSort(data,0,data.length-1);
        for (int i = 0; i < b.length; i++) {
            System.out.println(data[i]);
        }
    }
}
