package com.shijizhuo.gof.structure.decorator;

/**
 * 基本功能
 * Created by jzshi on 2019/7/2.
 */
public class BaseCar implements ICar {
    @Override
    public void move() {
        System.out.println("在地上跑");
    }
}
