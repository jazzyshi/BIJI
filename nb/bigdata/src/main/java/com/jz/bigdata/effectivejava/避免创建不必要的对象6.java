package com.jz.bigdata.effectivejava;

import java.util.*;

public class 避免创建不必要的对象6 {

    private static long sum(){
        Long sum1 = 0L;
        long startime1 = System.currentTimeMillis();
        for(long i=0;i<=Integer.MAX_VALUE;i++){
            sum1 += i;
        }
        System.out.println(System.currentTimeMillis()-startime1);

        long sum2 = 0L;//区别在这个地方
        long startime2 = System.currentTimeMillis();
        for(long i=0;i<=Integer.MAX_VALUE;i++){
            sum2 += i;
        }
        System.out.println(System.currentTimeMillis()-startime2);
        return sum1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        sum();

        List<String> a = new ArrayList<>();

        Comparator<Object> hascCodeOrder = Comparator.comparingInt(Object::hashCode);

        a.stream().sorted(hascCodeOrder);
    }
}
