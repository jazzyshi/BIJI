package com.shijizhuo.smvc.demo.action;

import com.shijizhuo.smvc.annotation.JZAutoWrited;
import com.shijizhuo.smvc.annotation.JZController;
import com.shijizhuo.smvc.annotation.JZRequestMapping;
import com.shijizhuo.smvc.annotation.JZRequestParam;
import com.shijizhuo.smvc.demo.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jzshi on 2019/6/16.
 */
@JZController
@JZRequestMapping("/demo")
public class DemoAction {

    @JZAutoWrited
    private IDemoService demoService;


    @JZRequestMapping("/query")
    public void query(HttpServletRequest req , HttpServletResponse res,String name){

        String result = demoService.get(name);


        try {
            res.getWriter().write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
