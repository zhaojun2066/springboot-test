package com.jufeng.springboot.mnvcvonfig;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/26
 * \* Time: 9:43
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 异步callable 拦截器
 */
public class AsyncCallableProcessor extends CallableProcessingInterceptorAdapter {

    //拦截callable 此时已经是callable当前的线程
    @Override
    public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
    }

    //callable 执行之后
    @Override
    public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
    }



    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {

        return new CustomException("timeout。。。");
    }
}