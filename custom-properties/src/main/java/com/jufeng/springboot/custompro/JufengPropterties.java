package com.jufeng.springboot.custompro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/29
 * \* Time: 10:05
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@ConfigurationProperties(prefix = "ju",locations = "classpath:/jufeng.properties")
public class JufengPropterties {
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