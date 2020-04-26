package com.jz.bigdata.algorithm.test;

import java.util.Arrays;

public class InsertSort {

    public static  void sort(int[] a){

        //选择第一个数作为排序开始的有序序列
        //从剩下的数从左往右选择一个和有序序列从右向左比较大小，插入都有些序列中

        for(int i =1 ;i<a.length;i++){
            for(int j=i-1;j>=0;j--){
                if(a[i] < a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    break;
                }
            }
        }

    }
    public static void main(String[] args) {
        int a[] = new int[]{1,2,4,2,10,8,6};
        sort(a);
        System.out.println(Arrays.toString(a));

    }
}
