package com.shijizhuo.gof.create.singlelon;

/**
 * 饿汉式单例模式
 * Created by jzshi on 2019/6/23.
 */
public class Singleton1 {

    //类初始化时立即加载这个对象（没有延时加载的优势，如果用不到浪费资源）。类加载时天然的线程安全的
    private static Singleton1 instance = new Singleton1();

    //方法没有同步，调用效率高
    public static Singleton1 getInstance(){
        return instance;
    }

    //私有的，不能new,只能通过getInstance
    private Singleton1(){

    }
}
