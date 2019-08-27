package com.shijizhuo.gof.create.factory.abstractfactory;

/**
 * Created by jzshi on 2019/6/24.
 */
public interface Engine {
    void start();
}

class GoodEngine implements Engine{

    @Override
    public void start() {
        System.out.println("发动机带自动启动");
    }
}

class BadEngine implements Engine{

    @Override
    public void start() {
        System.out.println("发动机不带自动启动");
    }
}