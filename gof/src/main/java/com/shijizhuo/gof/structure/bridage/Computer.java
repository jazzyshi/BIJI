package com.shijizhuo.gof.structure.bridage;

/**
 * Created by jzshi on 2019/7/1.
 */
public class Computer {
    Branch b;

    public Computer(Branch b){
        this.b = b;
    }

    public void sale(){
        b.sale();
    }
}
