package com.shijizhuo.gof.create.factory.abstractfactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public interface Seat {
    void soft();
}

class GoodSeat implements Seat{

    @Override
    public void soft() {
        System.out.println("座椅软");
    }
}

class BadSeat implements Seat{

    @Override
    public void soft() {
        System.out.println("座椅硬");
    }
}
