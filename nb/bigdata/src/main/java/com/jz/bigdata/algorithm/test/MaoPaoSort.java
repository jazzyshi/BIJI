package com.jz.bigdata.algorithm.test;


import java.util.Arrays;

public class MaoPaoSort {

    public static void sort(int a[]){

        //一共需要循环的趟数
        for(int i=1;i<a.length;i++){
            //单趟循环比较
            for(int j=0;j<a.length - i;j++){
                //比较左右两个值，把大的往下沉
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
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
