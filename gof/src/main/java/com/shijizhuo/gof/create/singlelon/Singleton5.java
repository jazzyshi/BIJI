package com.shijizhuo.gof.create.singlelon;

/**
 * 枚举本生就是单利模式
 * 由JVM从根本上提供保证！避免通过反射和反序列化的漏洞，最安全，由JVM底层实现
 * 缺点：无延时加载
 * Created by jzshi on 2019/6/23.
 */
public enum Singleton5 {

    //定义一个枚举的因素，他就代表了singleton的一个实例
    INSTANCE;

    //单例可以有自己的一个操作
    public void singletonOperation(){
        //功能处理
    }
}
