package com.shijizhuo.gof.structure.proxy.staticporxy;

/**
 * Created by jzshi on 2019/6/30.
 */
public class ProxyStar implements Star {

    private Star star;
    public ProxyStar(Star star){
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("代理人");
    }

    @Override
    public void signContarct() {
        System.out.println("代理人");
    }

    @Override
    public void bookTicket() {
        System.out.println("代理人");
    }

    @Override
    public void sing() {
       star.sing();
    }

    @Override
    public void getMoneny() {
        System.out.println("代理人");
    }
}
