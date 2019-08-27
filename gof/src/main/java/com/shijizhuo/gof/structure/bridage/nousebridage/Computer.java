package com.shijizhuo.gof.structure.bridage.nousebridage;

/**
 * 没有使用桥接模式的时候 扩展需要改动很大
 * Created by jzshi on 2019/7/1.
 */
 public interface Computer {

    void sale();
}

class DestTopComputer implements Computer{

    @Override
    public void sale() {
        System.out.println("台式机销售");
    }
}

class NotoBookComputer implements Computer{

    @Override
    public void sale() {
        System.out.println("笔记本销售");
    }
}

class PingGuoDestTopComputer extends DestTopComputer {
    @Override
    public void sale() {
        super.sale();
        System.out.println("苹果销售");
    }
}
class PingGuoNotBookComputer extends NotoBookComputer {

    @Override
    public void sale() {
        super.sale();
        System.out.println("苹果销售");
    }
}

class HuaShuoDestTopComputer extends DestTopComputer {
    @Override
    public void sale() {
        super.sale();
        System.out.println("华硕销售");
    }
}
class HuaShuoNotBookComputer extends NotoBookComputer {

    @Override
    public void sale() {
        super.sale();
        System.out.println("华硕销售");
    }
}
