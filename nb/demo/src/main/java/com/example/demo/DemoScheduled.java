package com.example.demo;/**
 * Created by jazzyshi on 2019/9/20.
 */

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoScheduled
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/20 15:56
 * @Version 1.0
 **/
@Component
public class DemoScheduled {
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledMethod(){
        System.out.println("woaini....");
    }
}
