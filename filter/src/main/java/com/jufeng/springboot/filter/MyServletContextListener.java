package com.jufeng.springboot.filter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 11:28
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

        System.out.println("ServletContex销毁");

    }



    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContex初始化");
    }
}