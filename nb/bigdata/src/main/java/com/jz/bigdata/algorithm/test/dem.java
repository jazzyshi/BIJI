package com.jz.bigdata.algorithm.test;

import sun.misc.Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class dem {
//    AtomicInteger a = new AtomicInteger();
//    public void foo(){
//        for(int i=0;i<10000;i++){
//            if (a.get() % 2 == 0) {
//                System.out.print("foo");
//                a.addAndGet(1);
//            }else{
//                i --;
//            }
//
//        }
//    }
//    public void bar(){
//        for(int i=0;i<10000;i++) {
//            if (a.get() % 2 == 1) {
//                System.out.print("bar");
//                a.addAndGet(1);
//            }else {
//                i--;
//            }
//
//        }
//    }

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition a = reentrantLock.newCondition();
    Condition b = reentrantLock.newCondition();


    public void foo(){

        for(int i=0;i<10;i++){
            System.out.println("foo");
            try {
                a.await();
                b.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void bar(){
        for(int i=0;i<10;i++){
            System.out.println("bar");
            try {
                b.await();
                a.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        dem d = new dem();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d.foo();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.bar();
            }
        }).start();
    }
}
