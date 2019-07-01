package com.shijizhuo.gof.structure.adapter;

/**
 * 对象适配器方式（组合的方式）
 * Created by jzshi on 2019/6/30.
 */
public class Adapter2 implements Target{
    private JianPan jianPan;
    @Override
    public void handleReq() {
        jianPan.request();
    }

    public Adapter2(JianPan jianPan){
        super();
        this.jianPan = jianPan;
    }
}
