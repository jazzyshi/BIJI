package com.jz.bigdata.gof.structure.decorator;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName SuperCar
 * @Description Decorator装饰角色
 * @Author jazzyshi
 * @Date 2019/9/16 16:46
 * @Version 1.0
 **/
public class SuperCar implements ICar {

    protected ICar car;

    SuperCar(ICar icar){
        super();
        this.car = icar;
    }

    @Override
    public void move() {
        car.move();
    }
}
