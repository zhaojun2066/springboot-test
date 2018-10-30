package com.jufeng.springboot.recivejson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/30
 * \* Time: 14:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * 、@requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
 *   比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型。
 * \
 */


@CrossOrigin("*")
@Controller
public class UserController {

    @RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestBody User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/xxx")
    public String index(){
        return "index";
    }
}