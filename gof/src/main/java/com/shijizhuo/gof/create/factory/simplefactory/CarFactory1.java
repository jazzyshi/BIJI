package com.shijizhuo.gof.create.factory.simplefactory;

/**
 * 简单工厂2 扩展时不符合OCP原则
 * Created by jzshi on 2019/6/24.
 */
public class CarFactory1 {

    public static Car createAudo(){
            return new Audi();
    }
    public static Car createByd(){
        return new Byd();
    }

}
