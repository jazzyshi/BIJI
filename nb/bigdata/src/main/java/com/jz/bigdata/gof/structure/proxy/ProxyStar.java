package com.jz.bigdata.gof.structure.proxy;/**
 * Created by jazzyshi on 2019/9/12.
 */

/**
 * @ClassName ProxyStar
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/12 11:43
 * @Version 1.0
 **/
public class ProxyStar implements Start {

    RealStart realStart;

    public ProxyStar(RealStart realStart){
        this.realStart = realStart;
    }

    @Override
    public void signContarct() {
        System.out.println("经纪人签合同");
    }

    @Override
    public void bookTinckrt() {
        System.out.println("经纪人定机票");
    }

    @Override
    public void singing() {
        System.out.println("经纪人唱歌不行  调用正式歌星唱歌");
        realStart.singing();
    }

    @Override
    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}
