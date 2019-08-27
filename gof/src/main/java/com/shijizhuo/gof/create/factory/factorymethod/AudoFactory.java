package com.shijizhuo.gof.create.factory.factorymethod;

/**
 * Created by jzshi on 2019/6/24.
 */
public class AudoFactory implements CarFactory{
    @Override
    public  Car createCar() {
        return new Audi();
    }
}
