package com.jz.bigdata.algorithm;

/**
 * 插入排序
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到响应的位置并插入
 */
public class ChaRuiSort {
    public static int[] doSort(int[] arrays){
        for(int i = 1;i<arrays.length;i++){
            int insertVal = arrays[i];//插入的数
            int index = i - 1;//被插入的位置（准备和前一个数比较）
            while(index >=0 && insertVal < arrays[index]){
                arrays[index + 1] = arrays[index];
                index --;//让index向前移动
            }
            arrays[index+1] = insertVal;//把插入的数放到合适的位置
        }

        return arrays;
    }
    public static void main(String[] args) {
        int[] aa = doSort(new int[]{10, 76, 19, 88, 8});
        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }
    }
}
