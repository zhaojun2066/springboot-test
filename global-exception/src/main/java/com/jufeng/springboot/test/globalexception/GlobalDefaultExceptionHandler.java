package com.jufeng.springboot.test.globalexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/26
 * \* Time: 10:10
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody Err
    defaultErrorHandler(HttpServletRequest req, Exception e)  {

//      // If the exception is annotated with @ResponseStatus rethrow it and let

//      // the framework handle it - like the OrderNotFoundException example

//      // at the start of this post.

//      // AnnotationUtils is a Spring Framework utility class.

//      if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)

//          throw e;

//

//      // Otherwise setup and send the user to a default error-view.

//      ModelAndView mav = new ModelAndView();

//      mav.addObject("exception", e);

//      mav.addObject("url", req.getRequestURL());

//      mav.setViewName(DEFAULT_ERROR_VIEW);

//      return mav;



        //打印异常信息：

        e.printStackTrace();

        System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");



        /*

         * 返回json数据或者String数据：

         * 那么需要在方法上加上注解：@ResponseBody

         * 添加return即可。

         */



        /*

         * 返回视图：

         * 定义一个ModelAndView即可，

         * 然后return;

         * 定义视图文件(比如：error.html,error.ftl,error.jsp);

         *

         */

        return new Err();

    }
}