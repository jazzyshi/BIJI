package com.jz.bigdata.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    public static int[] sort(int[] arrays){

        for(int i=0;i<arrays.length;i++){
            int min = arrays[i];
            int minLocation = i;
            for(int j=i;j<arrays.length;j++){
                if(min > arrays[j]){
                    min = arrays[j];
                    minLocation = j;
                }
            }
            if(minLocation != i){
                arrays[minLocation] = arrays[i];
                arrays[i] = min;
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
