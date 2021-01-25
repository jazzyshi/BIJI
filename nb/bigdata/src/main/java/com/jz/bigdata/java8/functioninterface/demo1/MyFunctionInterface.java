package com.jz.bigdata.java8.functioninterface.demo1;

/**
 * 函数式接口：有且只有一个抽象方法的接口
 * 当然接口中可以包含其它的方法（默认、静态、私有）
 *
 * @FunctionalInterface注解
 * 作用：可以检测一个接口是否是函数式接口
 *   是：编译成过
 *   否：编译失败（接口中没有抽象方法、抽象的方法不止一个）
 */

@FunctionalInterface
public interface MyFunctionInterface {
    //定义一个抽象方法
    public abstract void method();
}
