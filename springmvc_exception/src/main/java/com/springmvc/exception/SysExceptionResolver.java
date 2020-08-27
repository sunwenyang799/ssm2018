package com.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:35 2020/8/27
 * @ Description：异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException = null;
        if(e instanceof SysException){
            sysException = (SysException) e;
        }else{
            sysException = new SysException("系统正在维护中...");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errMsg",sysException.getErrMsg());
        return modelAndView;
    }
}
