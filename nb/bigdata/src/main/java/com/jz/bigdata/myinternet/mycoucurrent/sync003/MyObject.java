package com.jz.bigdata.myinternet.mycoucurrent.sync003;

/**
 * 对象锁的同步和异步问题
 *
 * 同步的概念就是共享，如果不是共享的资源就没有必要进行同步
 * 同步的概念是为了线程安全（原子性（同步）、可见性）
 * 异步的概念就是独立，相互之间不受任何的约束
 * @author alienware
 *
 */
public class MyObject {

	public synchronized void method1(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** synchronized */
	public void method2(){
			System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final MyObject mo = new MyObject();
		
		/**
		 * 分析：
		 * t1线程先持有object对象的Lock锁，t2线程可以以异步的方式调用对象中的非synchronized修饰的方法
		 * t1线程先持有object对象的Lock锁，t2线程如果在这个时候调用对象中的同步（synchronized）方法则需等待，也就是同步
		 */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method1();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method2();
			}
		},"t2");
		
		t1.start();
		Thread.sleep(100);
		t2.start();
		
	}
	
}
