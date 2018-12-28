package com.jufeng.springboot.async.request;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/24
 * \* Time: 17:27
 * \* To change this template use File | Settings | File Templates.
 * \
 */
@RequestMapping("/advertConfig")
@RestController
public class TestController {

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public Callable<String> findOne(){
        return () -> {
            return "hello world";
        };
    }

}