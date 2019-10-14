package com.jz.bigdata.gof.build;/**
 * Created by jazzyshi on 2019/9/11.
 */

/**
 * @ClassName JZBuildBuilder
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/11 17:33
 * @Version 1.0
 **/
public class JZBuildBuilder implements BuildBuilder {
    @Override
    public String ranliao() {
        return "jzshi产的燃料";
    }

    @Override
    public String weixin() {
        return "jzshi产的卫星";
    }

    @Override
    public String waibaozhaung() {
        return "jzshi产的外包装";
    }
}
