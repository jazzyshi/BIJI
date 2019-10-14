package com.jz.bigdata.gof.structure.decorator;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/16 16:53
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {

        //基本功能
        Car c = new Car();
        c.move();
        //添加新功能 ----- 飞行
        FlySuperCar car = new FlySuperCar(c);
        car.move();
    }
}
