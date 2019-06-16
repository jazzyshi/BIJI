package com.dubbo1.demo.consumer;

import com.dubbo1.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppConsumer
{
    public static void main( String[] args ) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        DemoService demoService = context.getBean("demoService11", DemoService.class);
        String hello = demoService.sayHello("world");
        float price = demoService.getPrice("");
        System.out.println("result: " + hello);


        try {
            Thread.sleep(1000000000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
