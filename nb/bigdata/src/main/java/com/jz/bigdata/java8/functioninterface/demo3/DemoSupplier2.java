package com.jz.bigdata.java8.functioninterface.demo3;

import java.util.function.Supplier;

public class DemoSupplier2 {
    public static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {

        int[] temps = {1,3,4,1111,23,33,99};

        int max = getMax(()->{
            int maxtemp = Integer.MIN_VALUE;
            for (int a : temps) {
                if(a > maxtemp){
                    maxtemp = a;
                }
            }
            return maxtemp;
        });

        System.out.println(max);

    }
}
