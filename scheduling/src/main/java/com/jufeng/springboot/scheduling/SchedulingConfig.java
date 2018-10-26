package com.jufeng.springboot.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 10:22
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {


    @Scheduled(cron = "0/20 * * * * ?")
    public void go(){
        System.out.println("go......");
    }
}