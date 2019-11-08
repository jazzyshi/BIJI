package com.jz.bigdata.myinternet.mynetty.catalina.servlets;


import com.alibaba.fastjson.JSONObject;
import com.jz.bigdata.myinternet.mynetty.catalina.http.GPRequest;
import com.jz.bigdata.myinternet.mynetty.catalina.http.GPResponse;
import com.jz.bigdata.myinternet.mynetty.catalina.http.GPServlet;

public class SecondServlet extends GPServlet {

	@Override
	public void doGet(GPRequest request, GPResponse response) {
		doPost(request, response);
	}
	
	@Override
	public void doPost(GPRequest request, GPResponse response) {
	    String str = JSONObject.toJSONString(request.getParameters());
	    response.write(str,200);
	}
	
}
