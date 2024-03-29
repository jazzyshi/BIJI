package com.jz.bigdata.myinternet.mydisruptor.generate2;


import com.jz.bigdata.myinternet.mydisruptor.generate1.Trade;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class Handler5 implements EventHandler<Trade>,WorkHandler<Trade> {
	  
    @Override  
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {  
        this.onEvent(event);  
    }  
  
    @Override  
    public void onEvent(Trade event) throws Exception {  
    	System.out.println("handler5: get price : " + event.getPrice());
        Thread.sleep(5000);
    	event.setPrice(event.getPrice() + 3.0);
    }  
}  