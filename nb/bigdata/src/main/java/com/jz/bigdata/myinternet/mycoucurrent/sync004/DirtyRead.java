package com.jz.bigdata.myinternet.mycoucurrent.sync004;
/**
 * 业务整体需要使用完整的synchronized，保持业务的原子性。
 * set/get都要sync才能保持整体一致性
 * @author alienware
 *
 */
public class DirtyRead {

	private String username = "bjsxt";
	private String password = "123";
	
	public synchronized void setValue(String username, String password){
		this.username = username;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.password = password;
		
		System.out.println("setValue最终结果：username = " + username + " , password = " + password);
	}

	/**
	 * 为了保证原子性加syncronized
	 */
	public  void getValue(){
		System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("paoguxueyuan", "456");
			}
		});
		t1.start();
		Thread.sleep(1000);
		
		dr.getValue();
	}
	
	
	
}
