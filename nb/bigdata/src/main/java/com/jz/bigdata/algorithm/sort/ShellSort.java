package com.jz.bigdata.algorithm.sort;

import com.google.gson.internal.$Gson$Types;

/**
 * 希尔排序
 */
public class ShellSort {
    public static int[] sort(int[] array) {

        int gap = array.length/2;

        while(gap >0){

            for(int i=gap;i<array.length;i++){
                int preIndex = i-gap;
                int temp = array[i];
                while (preIndex >=0 && array[preIndex] > temp){
                    array[preIndex+gap] = array[preIndex];
                    array[preIndex] = temp;
                    preIndex -= gap;
                }
            }

            gap = gap / 2;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[]{11,3,4,2,18,31,6};
        sort(a);
        for (int i : a) {
            System.out.print(i+"  ");
        }
    }
}
