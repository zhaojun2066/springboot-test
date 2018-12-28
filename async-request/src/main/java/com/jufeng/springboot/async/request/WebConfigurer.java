package com.jufeng.springboot.async.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/26
 * \* Time: 9:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description: web 相关配置
 * \
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");//.allowedMethods("POST","GET")
    }
    /**
     * 配置线程池
     * @return
     */
    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(500);
        taskExecutor.setMaxPoolSize(3000);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("async-callable-");
        // 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
        //处理 callable超时
        configurer.setDefaultTimeout(60*1000);
        // 设置一些拦截，具体方法 顺序 所属线程看打印日志
        configurer.registerCallableInterceptors(asyncCallableProcessor());
        configurer.setTaskExecutor(getAsyncThreadPoolTaskExecutor());
    }

    @Bean
    public AsyncCallableProcessor asyncCallableProcessor() {
        return new AsyncCallableProcessor();
    }

/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }*/

}