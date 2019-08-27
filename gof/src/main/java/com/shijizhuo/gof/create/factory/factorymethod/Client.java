package com.shijizhuo.gof.create.factory.factorymethod;

/**
 * Created by jzshi on 2019/6/24.
 */
public class Client {
    public static void main(String[] args) {
        Car c1 = new AudoFactory().createCar();
        c1.run();
    }
}
