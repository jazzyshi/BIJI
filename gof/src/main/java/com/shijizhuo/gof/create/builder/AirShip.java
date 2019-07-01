package com.shijizhuo.gof.create.builder;

/**
 * 宇宙飞船
 * Created by jzshi on 2019/6/24.
 */
public class AirShip {

    private Engine engine;//发动机
    private EscapeTower escapeTower;//逃逸塔

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}



class Engine {
    private String name;

    public Engine(String name){
        this.name = name;
    }

}

class EscapeTower{
    private String name;

    public EscapeTower(String name){
        this.name = name;
    }

}
