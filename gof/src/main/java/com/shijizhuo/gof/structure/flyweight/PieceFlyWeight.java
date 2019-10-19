package com.shijizhuo.gof.structure.flyweight;

/**
 * 抽象享元类（棋子）
 * Created by jzshi on 2019/7/2.
 */
public interface PieceFlyWeight {
    String getColor();
    String getSize();
    String getCircle();
    void display(OutPutLocation out);
}
