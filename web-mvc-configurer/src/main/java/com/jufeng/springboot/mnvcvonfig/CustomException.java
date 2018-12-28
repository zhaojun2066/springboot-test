package com.jufeng.springboot.mnvcvonfig;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/26
 * \* Time: 9:43
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CustomException extends RuntimeException {

    public CustomException(String msg){
        super(msg);
    }
}