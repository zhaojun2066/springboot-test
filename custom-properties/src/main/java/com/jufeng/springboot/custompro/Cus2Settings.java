package com.jufeng.springboot.custompro;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/29
 * \* Time: 10:02
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 读取application.properties 自定义的属性
 * \
 */
@ConfigurationProperties(prefix = "ju")
public class Cus2Settings {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}