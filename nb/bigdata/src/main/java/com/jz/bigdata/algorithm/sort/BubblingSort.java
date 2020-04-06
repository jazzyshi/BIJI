package com.jz.bigdata.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {

    public static int[] sort(int[] arrays){

        int length = arrays.length;
        while (length>=0){
            for(int j=0;j<length-1;j++){
                if(arrays[j] > arrays[j+1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                }
            }
            length --;
        }

        return arrays;
    }

    public static int[] sort1(int[] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] a = new int[]{11,3,4,2,18,31,6};
        sort(a);
        for (int i : a) {
            System.out.print(i+"    ");
        }
        sort1(a);
        for (int i : a) {
            System.out.print(i+"    ");
        }
    }

}
