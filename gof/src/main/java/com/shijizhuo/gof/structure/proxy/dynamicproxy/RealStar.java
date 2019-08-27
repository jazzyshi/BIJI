package com.shijizhuo.gof.structure.proxy.dynamicproxy;

/**
 * Created by jzshi on 2019/6/30.
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("真实明星confer()");
    }

    @Override
    public void signContarct() {
        System.out.println("真实明星signContarct()");
    }

    @Override
    public void bookTicket() {
        System.out.println("真实明星bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("史继卓唱歌");
    }

    @Override
    public void getMoneny() {
        System.out.println("真实明星getMoneny()");
    }
}
