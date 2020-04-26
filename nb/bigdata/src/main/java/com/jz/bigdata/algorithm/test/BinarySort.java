package com.jz.bigdata.algorithm.test;

import java.util.Arrays;

public class BinarySort {

    public static int sort(int a[],int search) {

        int left = 0;
        int right = a.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (search < a[mid]) {
                right = mid-1;
            }
            if (search > a[mid]) {
                left = mid+1;
            }
            if (search == a[mid]) {
                return mid;
            }

            System.out.println(left+":"+right);
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,4};
        Arrays.sort(a);
        System.out.println(sort(a,2));

    }
}
