package com.shijizhuo.gof.create.prototype;

import java.util.Date;

/**
 * 测试浅赋值
 * Created by jzshi on 2019/6/25.
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        Date date = new Date(1212121212);
        Sheep sheep = new Sheep("小史",date);
        Sheep sheepClone = (Sheep) sheep.clone();

        System.out.println(sheep.toString());
        System.out.println(sheepClone.toString());


        //原来羊
        System.out.println("原来的的羊："+sheep.getBirthdy());
        date.setTime(3333333);
        System.out.println("修改后的羊："+sheep.getBirthdy());

        //克隆羊
        System.out.println("克隆后的羊："+sheepClone.getBirthdy());




    }
}
