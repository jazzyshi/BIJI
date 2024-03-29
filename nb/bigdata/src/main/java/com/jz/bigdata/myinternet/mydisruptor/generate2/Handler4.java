package com.jz.bigdata.myinternet.mydisruptor.generate2;


import com.jz.bigdata.myinternet.mydisruptor.generate1.Trade;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class Handler4 implements EventHandler<Trade>,WorkHandler<Trade> {
	  
    @Override  
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {  
        this.onEvent(event);  
    }  
  
    @Override  
    public void onEvent(Trade event) throws Exception {
    	System.out.println("handler4: get name : " + event.getName());
    	Thread.sleep(3000);
    	event.setName(event.getName() + "h4");
    }  
}  