package com.shijizhuo.gof.structure.proxy.staticporxy;

/**
 * Created by jzshi on 2019/6/30.
 */
public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();
        Star starProxy = new ProxyStar(star);

        starProxy.sing();
        starProxy.bookTicket();

    }
}
