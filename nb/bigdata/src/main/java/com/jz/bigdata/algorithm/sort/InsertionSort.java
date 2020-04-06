package com.jz.bigdata.algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static int[] sort(int[] arrays){

        for(int i = 0;i<arrays.length;i++){
            for(int j = i;j>0;j--){
                if(arrays[j] < arrays[j-1]){
                    int temp=arrays[j];
                    arrays[j] =arrays[j-1];
                    arrays[j-1] = temp;
                }else {
                    break;
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
    }
}
