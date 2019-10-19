package com.jz.bigdata.gof.build;/**
 * Created by jazzyshi on 2019/9/11.
 */

/**
 * @ClassName JZBUildDirector
 * @Description 建造者模式 -- 构建和装配分开
 * @Author jazzyshi
 * @Date 2019/9/11 17:35
 * @Version 1.0
 **/
public class JZBUildDirector implements BuildDirector {

    BuildBuilder builder ;


    public JZBUildDirector(BuildBuilder buildBuilder){

        builder = buildBuilder;
    }


    @Override
    public AreaShip AirShipDirector() {
        //装配飞船
        AreaShip areaShip = new AreaShip();
        areaShip.setRanliao(builder.ranliao());
        areaShip.setWeixin(builder.weixin());
        areaShip.setWaibaozhuang(builder.waibaozhaung());

        return  areaShip;
    }
}
