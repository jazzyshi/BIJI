package com.jz.bigdata.java8.functioninterface.demo3;

import java.util.function.Consumer;

/**
 * java.util.consumer<T>接口刚好与Supplier接口相反，它不是生产一个数据，而实消费一个数据。其数据的类型由泛型决定
 * 该接口中包含一个抽象方法void accept(T t) ,意为消费一个指定泛型的数据
 * 至于具体怎么消费（使用），需要自定义（输出，计算。。。）
 */
public class DemoConsumer {
    /**
     * 定义一个方法
     * @param name 字符串的姓名
     * @param consumer Consumer接口，泛型使用String
     * 可以使用Consumer接口消费字符串的姓名
     */
    public static void method(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void main(String[] args) {
        method("刘德华",(String name) ->{
            //对传递的字符串进行消费：直接输出
            System.out.println(name);
            //消费方式：反转
            System.out.println(new StringBuffer(name).reverse().toString());
        });

        method("史继卓",s ->{ //注意！！（s）这个是参数，若抽象方法有几个参数，这边就几个
            //对传递的字符串进行消费：直接输出
            System.out.println(s);
            //消费方式：反转
            System.out.println(new StringBuffer(s).reverse().toString());
        });
    }
}
