package com.jz.bigdata.algorithm;

import java.util.TreeMap;

/**
 * 回溯算法：
 * 回溯算法实际上是一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，
 * 当发现已不满足求解条件时，就回溯返回，尝试别的路劲
 *
 * 最短路径算法：从某顶底出发，沿图的边到达另外一个顶点所经过的路径中，各边上权值之和最小的一条路径
 * 最大子数组算法
 * 最长公共子序算法
 * 最小生成树算法
 */
public class HuiSu {

    public void docc(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("xiaohong",1);
        treeMap.put("aapple",3);
        new HuiSu().docc();
    }
}
