package com.jufeng.springboot.test.globalexception;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 10:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Err {
    private String msg="err";
    private String code="100";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}