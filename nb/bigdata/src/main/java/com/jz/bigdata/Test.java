package com.jz.bigdata;

import java.util.*;

public class Test {

    public static void sortString(String s) {

//        本题重点在于排序，将字符和出现次数放到map，中，对map排序，进行字符串拼接即可
        char[] ch = s.toCharArray();
//        查找表（将数据存到一个表里，然后用去查找）问题首先想到map,map查找比list更优（更适合查找）
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }
        }
//        通过Arraylist构造函数吧map.entrySet()转化为list(map没有按值排序的方法，我们要把map转化为list,用比较器进行排序，map是无序的，在空间上的无序)
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//        通过比较器进行比较排序
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                逆序排序（从大到小），要顺序排序，o1-o2
                return o2.getValue() - o1.getValue();
            }
        });
//        用字符串类StrinBuilder（非线程安全，不支持并发），用来拼接（操作）字符串
        StringBuilder sb = new StringBuilder();
//        将排好序的列表遍历，得到排好序的集合，然后按值遍历，将键加入sb中，最后输出（集合的遍历，最优方法，entry）
        for (Map.Entry<Character, Integer> map1 : list) {
//            对每一个值进行遍历，例如e - 2,遍历两次，将e添加进去，t出现1词，遍历1次,将t添加进去。
            for (int i = 0; i < map1.getValue(); i++) {
                System.out.println(map1.getKey());
                sb.append(map1.getKey());
            }
        }
        System.out.println(sb.toString());

    }

    public static void main(String[] args) {

        sortString("treeaaA");
    }
}
