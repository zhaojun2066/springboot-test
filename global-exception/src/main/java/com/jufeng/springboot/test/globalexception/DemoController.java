package com.jufeng.springboot.test.globalexception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 10:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Controller
public class DemoController {
    @RequestMapping("/zeroException")
    public int zeroException(){

        return 100/0;

    }
}