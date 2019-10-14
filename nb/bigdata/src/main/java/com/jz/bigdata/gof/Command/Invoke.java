package com.jz.bigdata.gof.Command;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Invoke
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 14:00
 * @Version 1.0
 **/
public class Invoke {

    Command command;

    public Invoke(Command command){
        super();
        this.command = command;
    }

    public void call(){
        command.execute();
    };
}
