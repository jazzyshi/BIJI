package com.shijizhuo.gof.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * Created by jzshi on 2019/7/2.
 */
public class PieceFlyWeightFactory {

    //享元池
    private static Map<String,PieceFlyWeight> pool = new HashMap<String,PieceFlyWeight>();

    public static PieceFlyWeight getPiece(String color){
        if(pool.get(color) != null){
            return pool.get(color);
        }else{
            pool.put(color,new ConcreteFlyWeight(color,"1","圆形"));
            return pool.get(color);
        }
    }
}
