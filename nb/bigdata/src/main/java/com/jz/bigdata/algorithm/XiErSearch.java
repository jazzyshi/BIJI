package com.jz.bigdata.algorithm;

/**
 * 希尔排序
 */
public class XiErSearch {

    public static int[] doSort(int[] arrays){

        int dk = arrays.length /2;
        while (dk >=1){
            //类似插入排序。只是插入排序增量是1,这里的增量是dk
            for(int i=dk;i<arrays.length;i++){
                if(arrays[i] < arrays[i-dk]){
                    int j;
                    int x = arrays[i];//x为待插入的值
                    arrays[i]=arrays[i-dk];
                    for(j=i-dk;j>=0&&x<arrays[j];j=j-dk){
                        //通过循环，逐个后移找到要插入的位置
                        arrays[j+dk] = arrays[j];
                    }
                    arrays[j+dk] = x;//插入
                }
            }

            dk = dk/2;

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
