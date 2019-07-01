package com.shijizhuo.gof.create.builder;

/**
 * 装配
 * Created by jzshi on 2019/6/24.
 */
public class JZAirShipDirector implements AirShipDirector{

    private AirShipBuilder builder;

    public JZAirShipDirector(AirShipBuilder builder){
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {

        Engine e = builder.builderEngine();
        EscapeTower t = builder.builderEscapeTower();

        //装配成飞船对象
        AirShip airShip = new AirShip();
        airShip.setEngine(e);
        airShip.setEscapeTower(t);
        return airShip;
    }
}
