package com.jufeng.springboot.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 10:10
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \ servlet filter 注意不要忘记在 SpringBootSampleApplication.java 上添加 @ServletComponentScan 注解
 */

@ServletComponentScan
@SpringBootApplication
public class App {
    public static void main(String [] args){
        SpringApplication.run(App.class, args);
    }


    /**
     * 不在web.xml 里 配置filter
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public OnceFilter OnceFilter() {
        return new OnceFilter();
    }

    @Bean
    public FilterRegistrationBean corsRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(OnceFilter());
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 8);
        return filterRegistrationBean;
    }
}