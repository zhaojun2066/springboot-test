package com.jufeng.springboot.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 11:25
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@RestController
public class DemoController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
}