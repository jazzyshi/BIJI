package com.jz.bigdata.other.democlass;

/**
 *
 /**
 *java中任何类都继承Object类，getClass()方法在Object中被定义为final和native,子类不能覆盖该方法
 * Object中的getClass()的解释：发回此Object运行时的类
 *
 * 那如何获取父类中的名字：通过反射机制----getClass().getSuperclass().getName()
 */
class A{ }
class DemoClass extends A{
    public void test(){
        System.out.println(super.getClass().getName());
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getSuperclass().getName());
    }

    public static void main(String[] args) {

        new DemoClass().test();
    }
}