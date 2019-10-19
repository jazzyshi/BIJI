package com.shijizhuo.gof.structure.flyweight;

/**
 * 外部状态(UnSharedConcreteFlyWeight) = 非共享外部享元类
 * Created by jzshi on 2019/7/2.
 */
public class OutPutLocation {

    private String x;
    private String y;

    public OutPutLocation(String x,String y){
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
