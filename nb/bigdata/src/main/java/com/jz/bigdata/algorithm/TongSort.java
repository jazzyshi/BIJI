package com.jz.bigdata.algorithm;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

/**
 * 桶排序：
 * 把数组arr划分为n个大小相同子区间(桶)，每个子区间各自排序，最后合并。
 * 计算排序是桶排序的一种特殊情况，可以把计算排序当成每个桶里只有一个元素的情况
 */
public class TongSort {
     public static ArrayList<ArrayList<Integer>> bucketSort(int[] arr){

         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < arr.length; i++) {
             max = Math.max(arr[i],max);
             min = Math.min(arr[i],min);
         }
         //创建桶
         int bucketNum = (max-min)/arr.length + 1;
         ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
         for (int i = 0; i < bucketNum; i++) {
             bucketArr.add(new ArrayList<Integer>());
         }
         //将每个元素放入桶(放入前面桶的数据没有比后面桶里大的 为啥？)
         for (int i = 0; i < arr.length; i++) {
             int num = (arr[i] - min) /arr.length;
             bucketArr.get(num).add(arr[i]);
         }

         for (int i = 0; i < bucketArr.size() ; i++) {
             Collections.sort(bucketArr.get(i));
         }
         return bucketArr;
     }

    public static void main(String[] args) {
        int[] data = new int[]{76, 10, 19, 88,55,32};
        ArrayList<ArrayList<Integer>> bucketArr = bucketSort(data);
        System.out.println(bucketArr.toString());
    }
}
