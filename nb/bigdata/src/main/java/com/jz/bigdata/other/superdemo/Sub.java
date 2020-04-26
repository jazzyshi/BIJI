package com.jz.bigdata.other.superdemo;

/**
 * Call to 'super()' must be first statement in constructor body
 */
public class Sub extends Base {
    public Sub() {
        System.out.println("");
        //当子类构造函数需要显示调用父类构造函数时，super()必须为构造函数中的第一天语句，不然编译报错
        //super();
    }
}
