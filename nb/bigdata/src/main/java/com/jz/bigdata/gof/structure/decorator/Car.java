package com.jz.bigdata.gof.structure.decorator;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName Car
 * @Description ConcreteComponent 具体构建角色（真实对象）
 * @Author jazzyshi
 * @Date 2019/9/16 16:42
 * @Version 1.0
 **/
public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("我能动");
    }
}
