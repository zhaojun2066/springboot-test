package com.jufeng.springboot.unittest;

import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/29
 * \* Time: 9:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Service
public class UserService {
    public String getUsername(){
        return "jufeng";
    }
}