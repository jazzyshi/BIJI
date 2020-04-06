package com.jz.bigdata.other.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SuppliedThreadLocal.java
 * SuppliedThreadLocal是ThreadLoacl的静态内部类，ThreadLocal的withInitial方法使用Supplier对象创建SuppliedThreadLocal对象
 * 作用是为了在java8，支持使用函数式编程的方式设置并返回当前线程变量的初始值
 *
 * .InheritableThreadLocal.java
 * 作用：把父线程变量的值传递到子线程中。可通过重写childValue方法，改变从父线程中获取的值
 * 原理和解析：
 * 每个线程都还有另外一个ThreadLocalMap类型变量inheritableThreadLocals
 * InheritableThreadLocal重写了getMap和createMap方法，维护的不在是threadLocals，而是inheritableThreadLocals
 * 当主线程创建一个子线程的时候，会判断主线程的inheritableThreadLocals是否为空
 * 如果不为空，则会把inheritableThreadLocals的值传给子线程的inheritableThreadLocals，传送的逻辑是childValue实现的
 *
 * 注意：
 * 因为传送逻辑是在创建子线程的时候完成的，子线程创建后，主线程在修改InheritableThreadLocal变量的值，是无法传给子线程的
 * 创建子线程完成后，原则上子线程和父线程中InheritableThreadLocal变量的值在没有关联，各自调用set/get/remove都只影响本线程中的值
 * 如果InheritableThreadLocal变量的值是引用类型，通过get方法获取到对象后，直接修改了该对象的属性，则父线程和子线程都会受影响
 */
public class DemoInheritableThreadLocal {

    private static Map<String,String> maps = new HashMap<>();

    private static final InheritableThreadLocal<Map<String,String>> local = new InheritableThreadLocal<>();


    public static void main(String[] args){
        maps.put("name","史继卓");
        //主线程
        local.set(maps);
        //子线程
        new Thread(() -> {
            Map<String,String> temp = local.get();
            System.out.println(temp);
            temp.put("name","刘德华");
            System.out.println(local.get());
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(local.get());
    }


}
