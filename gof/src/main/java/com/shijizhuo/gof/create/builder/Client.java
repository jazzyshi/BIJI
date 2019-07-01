package com.shijizhuo.gof.create.builder;

/**
 * Created by jzshi on 2019/6/24.
 */
public class Client {

    public static void main(String[] args) {
        AirShipDirector director = new JZAirShipDirector(new JZAirShipBuilder());
        AirShip airShip = director.directAirShip();
    }
}
