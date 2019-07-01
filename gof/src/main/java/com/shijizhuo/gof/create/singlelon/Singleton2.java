package com.shijizhuo.gof.create.singlelon;

/**
 * 懒汉式单例模式
 * Created by jzshi on 2019/6/23.
 */
public class Singleton2 {

    //单列对象延迟加载
    private static Singleton2 instance;

    //真正用的时候才加载，资源利用高。但是调用方法都要同步，并发效率高
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

    //私有的，不能new
    private Singleton2(){

    }
}
