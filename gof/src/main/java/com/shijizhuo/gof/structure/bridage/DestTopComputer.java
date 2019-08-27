package com.shijizhuo.gof.structure.bridage;

/**
 * Created by jzshi on 2019/7/1.
 */
public class DestTopComputer extends Computer {
    public DestTopComputer(Branch b) {
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("台式机哦哦");
    }
}
