package com.shijizhuo.gof.structure.adapter;

/**
 * 适配器（类适配器方式）
 * 相当于（usb和ps/2的转化器）
 * Created by jzshi on 2019/6/30.
 */
public class Adapter extends JianPan implements Target{
    @Override
    public void handleReq() {
        super.request();
    }
}
