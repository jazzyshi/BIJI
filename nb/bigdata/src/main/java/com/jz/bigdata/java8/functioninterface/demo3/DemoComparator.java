package com.jz.bigdata.java8.functioninterface.demo3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 如果一个方法的返回类型是函数式接口，就可以直接方法一个lambda表达式
 * 当需要通过一个方法来获取一个java.util.comparator接口类型的对象作为排序器时，就可以调用该方法实现
 */
public class DemoComparator {

    public static Comparator<String> getComparator(){
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };
    }
    public static Comparator<String> getComparator1(){
        return (String a1,String a2) -> {
            return a2.length() - a1.length();
        };
    }

    //继续优化
    public static Comparator<String> getComparator2(){
        return (a1,a2) -> a2.length() - a1.length();
    }

    public static void main(String[] args) {
        String[] arr = {"aaaa","b","cccccc","d"};
        System.out.println(Arrays.toString(arr));
        //调用Arrays中的sort()方法,对字符串数组进行排序
        Arrays.sort(arr,getComparator2());
        System.out.println(Arrays.toString(arr));

    }

}
