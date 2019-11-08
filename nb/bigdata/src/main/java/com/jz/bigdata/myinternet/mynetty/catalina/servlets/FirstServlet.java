package com.jz.bigdata.myinternet.mynetty.catalina.servlets;

import com.jz.bigdata.myinternet.mynetty.catalina.http.GPRequest;
import com.jz.bigdata.myinternet.mynetty.catalina.http.GPResponse;
import com.jz.bigdata.myinternet.mynetty.catalina.http.GPServlet;

public class FirstServlet extends GPServlet {


    @Override
    public void doGet(GPRequest request, GPResponse response) {
        doPost(request, response);
    }


    @Override
    public void doPost(GPRequest request, GPResponse response) {
        String param = "name";
        String str = request.getParameter(param);
        response.write(param + ":" + str, 200);
    }

}
