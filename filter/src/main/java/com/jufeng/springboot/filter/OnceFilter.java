package com.jufeng.springboot.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/11/6
 * \* Time: 17:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 *
 * OncePerRequestFilter顾名思义，他能够确保在一次请求只通过一次filter，而不需要重复执行
 * 兼容不通的servlet版本 内部请求是否要经过过滤器
 */
public class OnceFilter extends OncePerRequestFilter {


    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}