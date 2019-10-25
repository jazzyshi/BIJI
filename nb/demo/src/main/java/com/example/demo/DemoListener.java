package com.example.demo;/**
 * Created by jazzyshi on 2019/9/19.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName DemoListener
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/19 15:29
 * @Version 1.0
 **/

@WebListener
public class DemoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener.......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
