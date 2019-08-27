package com.shijizhuo.gof.create.factory.abstractfactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public class BadCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new BadEngine();
    }

    @Override
    public Seat createSeat() {
        return new BadSeat();
    }
}
