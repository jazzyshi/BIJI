package com.shijizhuo.gof.create.factory.simplefactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("奥迪跑");
    }
}
