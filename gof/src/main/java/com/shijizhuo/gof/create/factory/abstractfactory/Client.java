package com.shijizhuo.gof.create.factory.abstractfactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public class Client {
    public static void main(String[] args) {
        CarFactory c1 = new GoodCarFactory();
        c1.createEngine().start();
        c1.createSeat().soft();
    }
}
