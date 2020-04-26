package com.jz.bigdata.other.duotai;

/**
 * !!!!!!请运行出结果
 * 只有类中的方法才有多态的概念，类中的成员没有多态的概念
 */
public class SubCxlass extends FatherClass{

    int a = 1;
    @Override
    public void g() {
        System.out.println("subclass g()");
    }

    public static void main(String[] args) {
        FatherClass fatherClass = new SubCxlass();
        fatherClass.g();
        System.out.println(fatherClass.a);
    }
}
