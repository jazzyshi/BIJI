package com.shijizhuo.gof.create.factory.abstractfactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
}
