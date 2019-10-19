package com.shijizhuo.gof.structure.flyweight;

/**
 * Created by jzshi on 2019/7/2.
 */
public class ConcreteFlyWeight implements PieceFlyWeight {

    private String color, size, circle;

    public ConcreteFlyWeight(String color, String size, String circle) {
        this.color = color;
        this.size = size;
        this.circle = circle;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSize() {
        return this.size;
    }

    @Override
    public String getCircle() {
        return this.circle;
    }

    @Override
    public void display(OutPutLocation out) {
        System.out.println("颜色：" + color);
        System.out.println("大小：" + size);
        System.out.println("形状：" + circle);

        System.out.println("棋子位置：" + out.getX() + "," + out.getY());
    }

}