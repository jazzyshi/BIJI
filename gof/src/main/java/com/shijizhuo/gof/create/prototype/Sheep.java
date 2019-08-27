package com.shijizhuo.gof.create.prototype;

import java.util.Date;

/**
 * 原型模式（浅复制）
 * Created by jzshi on 2019/6/25.
 */
public class Sheep implements Cloneable {

    private String name;
    private Date birthdy;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();//直接调用object对象的clone()方法
    }

    public Sheep(String name,Date birthdy){
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
