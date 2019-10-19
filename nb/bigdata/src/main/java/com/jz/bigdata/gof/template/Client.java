package com.jz.bigdata.gof.template;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 14:36
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        DemoTemplate demoTemplate = new DemoTemplate() {
            @Override
            public void do2() {
                System.out.println("存钱");
            }
        };

        DemoTemplate demoTemplate1 = new DemoTemplate() {
            @Override
            public void do2() {
                System.out.println("取钱");
            }
        };

        demoTemplate.process();
        demoTemplate1.process();
    }
}
