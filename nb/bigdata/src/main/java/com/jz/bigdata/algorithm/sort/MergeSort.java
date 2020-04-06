package com.jz.bigdata.algorithm.sort;

import java.util.Arrays;

/**
 *
 */
public class MergeSort {

    public static int[] sort(int[] arrays){

        int length = arrays.length;
        if(length < 2){
            return arrays;
        }
        int mid = length/2;

        int[] leftArray = Arrays.copyOfRange(arrays,0,mid);
        int[] rightArray = Arrays.copyOfRange(arrays,mid,length);

        return merge(sort(leftArray),sort(rightArray));
    }

    private static int[] merge(int[] arrays1, int[] arrays2) {
        int[] result = new int[arrays1.length + arrays2.length];
        int a1 = arrays1.length;
        int a2= arrays2.length;
        for(int i=0,m=0,n=0;i<result.length;i++){
            if(m < arrays1.length && n < arrays2.length){
                if(arrays1[m] < arrays2[n]){
                    result[i] = arrays1[m++];
                }else if(arrays1[m] > arrays2[n]){
                    result[i] = arrays2[n++];
                }else{
                    result[i] = arrays1[m++];
                }
            }else if(m >= arrays1.length && n < arrays2.length){
                result[i] = arrays2[n++];
            }else if(m < arrays1.length && n >= arrays2.length){
                result[i] = arrays1[m++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{11,3,4,2,18,31,6};
        int[] b = sort(a);
        for (int i : b) {
            System.out.print(i+"  ");
        }
    }
}
