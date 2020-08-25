package com.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 17:16 2020/8/23
 * @ Description：用于记录日志的工具类，提供了公共的代码
 */
@Aspect//表示当前是一个切面
@Component("logger")
public class Logger {

    @Pointcut("execution(* com.spring.service.impl.*.*(..))")
    private void pointCut(){}
    /**
     * 前置通知
     */
//    @Before("pointCut()")
    public void beforePrintLog(){
        System.out.println("前置通知执行了");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pointCut()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知执行了");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pointCut()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知执行了");
    }

    /**
     * 最终通知
     */
//    @After("pointCut()")
    public void afterPrintLog(){
        System.out.println("最终通知执行了");
    }

    /**
     * 环绕通知
     * @return
     * 问题：当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：通过动态代理中的环绕通知代码，发现动态代理的环绕通知有明确切入点方法的调用，而我们没有
     * 解决：spring框架为我们提供了一个接口：ProceedingJoinPoint。
     *      该接口有一个方法proceed()，此方法就就相当于明确调用切入点方法
     *      该接口可以作为环绕通知方法的参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们调用
     * spring的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    @Around("pointCut()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object value = null;
        try {
            beforePrintLog();
            Object[] args = proceedingJoinPoint.getArgs();//得到方法所需参数
            value= proceedingJoinPoint.proceed(args);
            afterReturningPrintLog();
            return value;
        } catch (Throwable throwable) {
            afterThrowingPrintLog();
            throw new RuntimeException(throwable);
        }finally {
            afterPrintLog();
        }
    }
}
