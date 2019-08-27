package com.shijizhuo.gof.create.singlelon;

/**
 * 静态内部类
 * 外部类没有static属性，则不会像饿汉式那样立即加载对象
 * 只有真正调用getInstance的时候才会加载静态内部类。加载类是天然线程安全的
 * instance是static final类型，保证内存中只有这样一个实列存在，而且只能赋值一次，从而保证线程安全
 * 兼备了并发高效调用和延迟加载的优势
 * Created by jzshi on 2019/6/23.
 */
public class Singleton4 {

    private static class SingletonClassInstance{
        private static final Singleton4 instance = new Singleton4();
    }

    //方法没有同步，调用效率高
    public static Singleton4 getInstance(){
        return  SingletonClassInstance.instance;
    }

    private Singleton4(){}
}
