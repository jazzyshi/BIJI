package com.jz.bigdata.gof.structure.decorator;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName FlySuperCar
 * @Description 具体装饰模式
 * @Author jazzyshi
 * @Date 2019/9/16 16:49
 * @Version 1.0
 **/
public class FlySuperCar extends SuperCar {

    FlySuperCar(ICar icar) {
        super(icar);
    }

    public void fly(){
        System.out.println("我还能飞呢");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
