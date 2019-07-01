package com.shijizhuo.gof.create.factory.simplefactory;

/**
 * 在没有工厂模式的情况下
 * Created by jzshi on 2019/6/24.
 */
public class Client01 { //调用者 需要知道的好多 要知道怎么去造车 我一个司机为啥要知道

    public static void main(String[] args) {
        Car c1 = new Audi();
        Car c2 = new Byd();

        c1.run();
        c2.run();
    }
}
