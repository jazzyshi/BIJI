package com.shijizhuo.gof.create.factory.simplefactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public class Client02 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createCar("奥迪");
        Car c2 = CarFactory.createCar("比亚迪");

        c1.run();
        c2.run();

        Car c3 = CarFactory1.createAudo();
        Car c4 = CarFactory1.createByd();
        c3.run();
        c4.run();

    }
}
