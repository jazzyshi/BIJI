package com.shijizhuo.gof.structure.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by jzshi on 2019/6/30.
 */
public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        StarHandler handler = new StarHandler(real);

        Star star = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},handler);
        star.bookTicket();
        star.sing();
    }
}
