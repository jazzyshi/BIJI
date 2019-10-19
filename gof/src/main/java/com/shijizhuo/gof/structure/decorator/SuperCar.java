package com.shijizhuo.gof.structure.decorator;

/**
 * 扩展功能
 * Created by jzshi on 2019/7/2.
 */
public class SuperCar implements ICar {

    ICar car;
    public SuperCar(ICar icar){
        super();
        car = icar;
    }

    @Override
    public void move() {
       car.move();
    }
}

class FlyCar extends SuperCar{

    public FlyCar(ICar icar) {
        super(icar);
    }

    public void fly(){
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

class WaterCar extends SuperCar{

    public WaterCar(ICar icar) {
        super(icar);
    }

    public void swim(){
        System.out.println("水里游");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}
