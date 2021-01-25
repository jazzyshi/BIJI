package com.jz.bigdata.effectivejava;

public class Car {
    int i = 0;
    public Car(){
        g();
    }
    public void g() {
        System.out.println("Car");
    }
}

class CarSub extends Car {
    public void setI(int i) {
        this.i = i;
    }

    int i= 1;
    public void g(){
        System.out.println("CarSub");
    }


    public static void main(String[] args) {
        Car car = new CarSub();
        System.out.println(car.i);
    }
}
