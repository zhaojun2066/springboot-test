package com.jufeng.springboot.mvc;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/30
 * \* Time: 9:44
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class User {
    private Integer id;
    private String name;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}