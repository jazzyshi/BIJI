package com.jz.bigdata.myinternet.mysocketio.thenetty.runtime;

import java.io.Serializable;

public class RequestData implements Serializable{

	private static final long  SerialVersionUID = 1L;
	
	private String id ;
	private String name ;
	private String requestMessage ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRequestMessage() {
		return requestMessage;
	}
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}


}
