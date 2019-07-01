package com.shijizhuo.gof.create.builder;

/**
 * 构建
 * jz牌宇宙飞船
 * Created by jzshi on 2019/6/24.
 */
public class JZAirShipBuilder implements AirShipBuilder{
    @Override
    public Engine builderEngine() {
        System.out.println("构造JZ牌发送机");
        return new Engine("构造JZ牌发动机");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构造JZ牌逃逸塔");
        return new EscapeTower("构造JZ牌逃逸塔");
    }
}
