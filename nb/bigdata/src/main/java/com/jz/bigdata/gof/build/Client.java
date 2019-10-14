package com.jz.bigdata.gof.build;/**
 * Created by jazzyshi on 2019/9/11.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/11 17:54
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        JZBUildDirector jzbUildDirector = new JZBUildDirector(new JZBuildBuilder());
        AreaShip areaShip=  jzbUildDirector.AirShipDirector();

        System.out.println(areaShip.toString());
    }
}
