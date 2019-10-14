package com.jz.bigdata.gof.structure.adapt;/**
 * Created by jazzyshi on 2019/9/12.
 */

/**
 * @ClassName Adapter
 * @Description 类适配器
 * @Author jazzyshi
 * @Date 2019/9/12 10:45
 * @Version 1.0
 **/
public class Adapter extends Adaptee implements Target {

    //实现接口 客户希望的
    @Override
    public void handleRequest() {
        super.handleR();
        System.out.println("客户欧洲的 需要三座的插头,我作适配吧");
    }
}
