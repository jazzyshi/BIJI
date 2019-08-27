package com.shijizhuo.gof.structure.bridage;

/**
 * Created by jzshi on 2019/7/1.
 */
public class Client {
    public static void main(String[] args) {
        Branch b = new HuaShuoBranch();
        Computer c = new DestTopComputer(b);
        c.sale();
    }
}
