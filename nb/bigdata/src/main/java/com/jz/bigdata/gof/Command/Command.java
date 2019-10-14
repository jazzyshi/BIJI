package com.jz.bigdata.gof.Command;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Command
 * @Description 抽象命令类
 * @Author jazzyshi
 * @Date 2019/9/17 11:40
 * @Version 1.0
 **/
public interface Command {
    void execute();
}

//具体命令类
class ConcreteCommand implements Command{

    Receiver receiver;

    public ConcreteCommand(Receiver r){
        this.receiver = r;
    }

    @Override
    public void execute() {
        receiver.doCommand();
    }
}
