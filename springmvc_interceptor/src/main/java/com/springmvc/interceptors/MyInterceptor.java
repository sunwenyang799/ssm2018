package com.springmvc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lenovo
 * @description: 自定义拦截器
 * @date 2020/8/28 9:46
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     *实现接口的预处理方法，controller方法执行前
     * return true 放行，执行下一个拦截器，如果没有执行controller中的方法
     * return false 不放行
     * @param request
     * @param response
     * @param handler
     *
     *
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor执行了...preHandle");
        return true;
    }

    /**
     * 后处理方法，successjsp 执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor执行了...postHandle");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    /**
     * 最终处理方法 success.jsp执行之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            System.out.println("MyInterceptor执行了...afterCompletion");
    }
}
