package com.jz.bigdata.effectivejava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Tets {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CarSub carSub = new CarSub();
        carSub.setI(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(carSub.i);
            }
        }).start();

        carSub.setI(2);

        Thread.sleep(5000);
        System.out.println(carSub.i);
    }

}
