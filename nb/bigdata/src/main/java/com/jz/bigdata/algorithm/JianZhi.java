package com.jz.bigdata.algorithm;

/**
 * 剪枝算法
 * 在搜索算法优化中，剪枝就是通过某种判断。避免一些不必要的遍历过程
 */
public class JianZhi {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{Integer.valueOf(1)};
        printArray(a);
    }

    public static <E> void printArray(E[] inpitArray){

        for (E e : inpitArray){
            System.out.printf("%s",e);
        }
    }
}
