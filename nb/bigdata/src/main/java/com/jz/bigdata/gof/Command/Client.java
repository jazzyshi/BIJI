package com.jz.bigdata.gof.Command;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 14:04
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Command c = new ConcreteCommand(new Receiver());
        Invoke invoke = new Invoke(c);
        invoke.call();

        new Receiver().doCommand();
    }
}
