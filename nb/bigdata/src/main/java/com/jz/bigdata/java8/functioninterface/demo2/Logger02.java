package com.jz.bigdata.java8.functioninterface.demo2;

/**
 * 使用lambda优化日志案例
 * lambda特点：延时加载
 * lambda使用前提：必须存在函数式接口
 */
public class Logger02 {
    //定义一下显示日志的方法.方法的参数传递日志的等级和MessageBuilder接口
    public static void showLog(int level,MessageBuilder messageBuilder){
        //对日志的级别进行判断，如果是1级，则调用messagebuilder接口中的method方法
        if(level == 1){
            System.out.println(messageBuilder.method());
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "hello";
        String msg2 = "world";
        String msg3 = "shijizhuo";

        /*
        使用Lambda表达式作为参数传递，仅仅是吧参数传递到showlog方法中
        只有满足条件，日志等级是1：才会调用接口MessageBuilder中的method,才会进行字符串的拼接
        所以不会存在性能的浪费
         */
        showLog(2,() -> {
            return msg1 + msg2 + msg3;
        });
    }
}
