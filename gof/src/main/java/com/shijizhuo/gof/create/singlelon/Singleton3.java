package com.shijizhuo.gof.create.singlelon;

/**
 * 双重检测锁实现（减少锁粒度）
 * 将同步类容放到if内部，提高了执行效率，不必每次获取对象都进行同步。
 * 只有第一次进行同步
 *
 * 问题：由于编译器优化原因和JVM底层内部模型原因，偶尔会出现问题，不建议使用
 * Created by jzshi on 2019/6/23.
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    public static Singleton3 getInstance(){
        if(instance == null){
            Singleton3 sc;
            synchronized (Singleton3.class){
                sc = instance;
                if(sc == null){
                    synchronized (Singleton3.class){
                        sc = new Singleton3();
                    }
                }
                instance = sc;
            }
        }
        return instance;
    }

    //这个方法是我自己写的，感觉可以达到同样的效果
    public static Singleton3 getInstance1(){
        if(instance == null){
            synchronized (Singleton3.class){
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    //私有的，不能new
    private Singleton3(){}
}
