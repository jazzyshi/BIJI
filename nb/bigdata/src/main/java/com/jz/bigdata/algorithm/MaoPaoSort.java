package com.jz.bigdata.algorithm;

/**
 * 冒泡排序算法
 * 比较前后相邻的两个数，如果前面数据大于后面的数据，就将这两个数据交换
 * 这样进行一次遍历后，最大的一个数就"沉"到数组的第N-1位置
 */
public class MaoPaoSort {

    public static int[] doSearc(int[] array){
        int length = array.length;
        for(int i=0; i<length; i++){
            for(int j= 1 ; j < length-i;j++){
                if(array[j-1] > array[j]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return  array;
    }

    public static void main(String[] args) {
        int[] aa = doSearc(new int[]{10, 76, 19, 88, 8});
        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }
    }
}
