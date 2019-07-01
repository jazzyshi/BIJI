package com.shijizhuo.gof.create.prototype;

import java.util.Date;

/**
 * 原型模式（深复制）
 * Created by jzshi on 2019/6/25.
 */
public class Sheep1 implements Cloneable {

    private String name;
    private Date birthdy;

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object obj = super.clone();

        //添加下面代码实现深赋值
        Sheep1 s = (Sheep1) obj;
        s.setBirthdy((Date) this.birthdy.clone());

        return obj;//直接调用object对象的clone()方法
    }

    public Sheep1(String name, Date birthdy){
        this.name = name;
        this.birthdy = birthdy;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdy() {
        return birthdy;
    }

    public void setBirthdy(Date birthdy) {
        this.birthdy = birthdy;
    }
}
