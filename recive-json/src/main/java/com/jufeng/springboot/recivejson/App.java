package com.jufeng.springboot.recivejson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 9:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \//其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，
 * 等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
 */

@SpringBootApplication
public class App {

    public static void main(String [] args){
        SpringApplication.run(App.class, args);
    }
}