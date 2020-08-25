package com.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:08 2020/8/22
 * @ Description：和事务相关的工具类，包含开启事务，提交事务，事务回滚和释放连接
 *
 * !!!注意：注解实现aop 最终通知会在后置通知之前执行,解决方法：注解使用环绕通知
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private  ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.spring.service.impl.AccountServiceImpl_proxy.*(..))")
    private void pt(){}

    /**
     * 开启事务
     */
//    @Before("pt()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("pt()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("pt()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
//    @After("pt()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//不是关闭线程，而是把线程还回到线程池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("pt()")
    public void manage(ProceedingJoinPoint proceedingJoinPoint){
        this.beginTransaction();
        Object[] args = proceedingJoinPoint.getArgs();
        try {
            proceedingJoinPoint.proceed(args);
            this.commit();
        } catch (Throwable throwable) {
            this.rollback();
            throwable.printStackTrace();
        }finally {
            this.release();
        }

    }


}
