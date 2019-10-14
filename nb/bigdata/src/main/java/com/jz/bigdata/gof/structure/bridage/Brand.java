package com.jz.bigdata.gof.structure.bridage;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName Brand
 * @Description 按品牌的维度
 * @Author jazzyshi
 * @Date 2019/9/16 15:11
 * @Version 1.0
 **/
public interface Brand {
    void sale();
}

class Lenvo implements Brand{

    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}
