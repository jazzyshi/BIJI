package com.shijizhuo.gof.structure.bridage.nousebridage;


/**
 * Created by jzshi on 2019/7/1.
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new HuaShuoDestTopComputer();
        computer.sale();
    }
}
