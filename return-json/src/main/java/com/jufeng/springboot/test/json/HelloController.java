package com.jufeng.springboot.test.json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 9:57
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public User getUser(){
        User user = new User();
        user.setName("jufeng");
        user.setAge(30);
        return user;
    }
}