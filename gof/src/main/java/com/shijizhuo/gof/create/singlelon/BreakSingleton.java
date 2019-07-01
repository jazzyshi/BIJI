package com.shijizhuo.gof.create.singlelon;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;

/**
 * 反射可以破解单例上面几种（除去枚举）实现方式
 *    -- 可以在构造函数中手动抛出异常控制
 * 反序列化可以破解单例上面几种（除去枚举）实现方式
 *    --可以通过定义readResolve()防止获得不同对象
 *      反序列化时，如果对象所在的类定义了readResolve(),（实际上是一种回调），定义返回哪个对象
 * Created by jzshi on 2019/6/23.
 */
public class BreakSingleton implements Serializable{

    //单列对象延迟加载
    private static BreakSingleton instance;

    //真正用的时候才加载，资源利用高。但是调用方法都要同步，并发效率高
    public static synchronized BreakSingleton getInstance(){
        if(instance == null){
            instance = new BreakSingleton();
        }
        return instance;
    }

    //私有的，不能new
    private BreakSingleton(){

        //解决发射漏洞
//        if(instance != null){
//            throw new RuntimeException();
//        }

    }

    //反序列化时，如果定义了这个方法，则直接返回次此方法指定的对象。而不需要单独再创建新对象
//    private Object readResolve(){
//        return instance;
//    }

}
