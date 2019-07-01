package com.shijizhuo.gof.structure.proxy.staticporxy;

/**
 * Created by jzshi on 2019/6/30.
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("真实明星");
    }

    @Override
    public void signContarct() {
        System.out.println("真实明星");
    }

    @Override
    public void bookTicket() {
        System.out.println("真实明星");
    }

    @Override
    public void sing() {
        System.out.println("真实明星");
    }

    @Override
    public void getMoneny() {
        System.out.println("真实明星");
    }
}
