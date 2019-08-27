package com.shijizhuo.gof.create.factory.simplefactory;

/**
 * 简单工厂1 扩展时不符合OCP原则
 * Created by jzshi on 2019/6/24.
 */
public class CarFactory {

    public static Car createCar(String type){
        if("奥迪".equals(type)){
            return new Audi();
        }else if("比亚迪".equals(type)){
            return new Byd();
        }else{
            return null;
        }
    }

}
