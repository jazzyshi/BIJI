package com.jz.bigdata.myinternet.mycoucurrent.sync005;
/**
 * synchronized的重入
 * 当一个线程得到了一个对象的锁后，再次请求时是可以再次获得该对象的锁
 * @author alienware
 *
 */
public class SyncDubbo2 {

	static class TheMain {
		public int i = 10;
		public synchronized void operationSuper(){
			try {
				i--;
				System.out.println("TheMain print i = " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class TheSub extends TheMain {
		public synchronized void operationSub(){
			try {
				while(i > 0) {
					i--;
					System.out.println("TheSub print i = " + i);
					Thread.sleep(100);		
					this.operationSuper();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				TheSub sub = new TheSub();
				sub.operationSub();
			}
		});
		
		t1.start();
	}
	
	
}
