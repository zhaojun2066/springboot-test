package com.jufeng.springboot.mvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/30
 * \* Time: 9:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/users")// 通过这里配置使下面的映射都在/users下
public class UserController {

    private static Map<Integer,User> users = Collections.synchronizedMap(new HashMap<Integer,User>());


    @RequestMapping(value = "/getUserList", method= RequestMethod.GET)
    public List<User> getUserList(){
        return new ArrayList<>(users.values());
    }


    @RequestMapping(value = "/addUser", method= RequestMethod.POST)
    public String addUser(User user){
        users.put(user.getId(),user);
        return"success";
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, User user){
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        users.put(id, user);
        return"success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        // url中的id可通过@PathVariable绑定到函数的参数中
        users.remove(id);
        return"success";

    }

}