package com.jz.bigdata.java8.functioninterface.demo3;

public class DemoRunnable {

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("33333");
            }
        });

        new Thread(()->System.out.println("1234")).start();
    }
}
