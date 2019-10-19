package com.shijizhuo.gof.structure.decorator;

/**
 * Created by jzshi on 2019/7/2.
 */
public class Client {
    public static void main(String[] args) {
        ICar carBase = new BaseCar();
        carBase.move();
        System.out.println("-----------------------------");
        FlyCar carFly = new FlyCar(new BaseCar());
        carFly.move();
        System.out.println("-----------------------------");
        WaterCar waterCar = new WaterCar(new BaseCar());
        waterCar.move();
        System.out.println("-----------------------------");
        WaterCar waterCar1 = new WaterCar(new FlyCar(new BaseCar()));
        waterCar1.move();
    }
}
