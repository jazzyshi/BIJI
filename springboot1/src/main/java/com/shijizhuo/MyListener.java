package com.shijizhuo;/**
 * Created by jazzyshi on 2019/6/3.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName MyListener
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/3 18:55
 * @Version 1.0
 **/
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0){

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0){
        System.out.println("Listener....init");
    }

}
