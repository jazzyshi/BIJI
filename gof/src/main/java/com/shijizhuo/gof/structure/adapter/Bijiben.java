package com.shijizhuo.gof.structure.adapter;

/**
 * 客户端类
 * （相当于笔记本，只有USB接口）
 * Created by jzshi on 2019/6/30.
 */
public class Bijiben {

    public void tets1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Bijiben c = new Bijiben();
        //Target t = new Adapter();

        JianPan jianPan = new JianPan();
        Target t2 = new Adapter2(jianPan);

        c.tets1(t2);
    }
}
