package com.jufeng.ss;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 10:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:不在扫描包的范围内可以通过下面的方式
 * \  @Import(value={SpringUtil.class})
 * SpringUtil是不需要添加@Component注解
 */

public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtils.applicationContext == null){

            SpringUtils.applicationContext  = applicationContext;

        }
    }

    public static ApplicationContext getContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name,Class<T> z){
        return applicationContext.getBean(name,z);
    }

    public static <T> T getBean(Class<T> clazz){

        return applicationContext.getBean(clazz);

    }
}