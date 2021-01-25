package com.jz.bigdata.java8.functioninterface.demo2;

/**
 * 实现以下代码存在一些性能问题
 * 调用shoelog方法，传递的第二个参数是拼接后的字符串
 * 先把字符串拼接好再调用showlog方法，如果传递的level不是1，
 * 那么拼接后的字符串就白拼接了，存在了浪费
 */
public class Logger01 {

    //定义一个日志的级别，显示日志信息的方法
    public static void showLog(int level,String message){
        //对日志的界别进行判断，如果是1级别，那么输出日志信息
        if(level == 1){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "hello";
        String msg2 = "world";
        String msg3 = "shijizhuo";

        String msg = msg1 + msg2 + msg3;

        showLog(1,msg);

    }
}
