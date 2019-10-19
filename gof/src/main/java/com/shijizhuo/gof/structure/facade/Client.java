package com.shijizhuo.gof.structure.facade;

/**
 * 外观模式
 * Created by jzshi on 2019/7/2.
 */
public class Client {
    public static void main(String[] args) {
        CommonFacade c = new CommonFacade();
        c.openCommany();
    }
}
