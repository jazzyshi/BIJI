package com.jz.bigdata.gof.Command;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Receiver
 * @Description 真正的命令执行者
 * @Author jazzyshi
 * @Date 2019/9/17 13:53
 * @Version 1.0
 **/
public class Receiver {
    public void doCommand(){
        System.out.println("执行action");
    }
}
