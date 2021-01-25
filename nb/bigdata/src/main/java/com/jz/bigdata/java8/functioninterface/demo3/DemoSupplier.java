package com.jz.bigdata.java8.functioninterface.demo3;

import java.util.function.Supplier;

/**
 * jdk提供了大量的函数式接口以丰富Lambda的典型使用场景，他们主要在java.util.function包中被提供
 *
 * java.util.function.Supplier<T>接口仅包含一个无参的方法 T get()。 用来获取一个泛型参数指定类型的对象数据
 * Supplier<T>接口被称之为生产行的接口，指定接口的泛型是什么类型，那么接口中的get方法就会产生什么类型的数据
 *
 */
public class DemoSupplier {

    //定义一个方法，方法的参数传递suppilier<T>接口，泛型的类型是String,那么get方法就会返回一个String
    public static String getString(Supplier<String> stringSupplier){
        return stringSupplier.get();
    }
    public static void main(String[] args){

        //调用getString方法，方法的参数是一个函数式接口，所以可以传递lambda表达式
       String s =  getString(()-> "胡歌");

       System.out.println(s);
    }
}
