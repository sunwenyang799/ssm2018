package com.spring.cglib;

import com.spring.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 15:00 2020/8/23
 * @ Description：基于子类的动态代理实现
 */
public class CglibClassClient {

    public static void main(String[] args){
        final Producer producer = new Producer();
        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法进行增加
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于子类的动态代理
         *      涉及的类：Enhancer
         *      提供者：第三方 cglib库
         *  如何创建代理对象
         *      使用Enhancer类中的create方法
         *  创建代理对象的要求：
         *      被代理对象不能是最终类
         *   create方法参数：
         *      class：字节码
         *      它用于指定被代理对象的字节码
         *      Callback：用于提供增强的代码
         *      它让我们写如何实现代理。我们一般都是写一个该接口的子接口实现类（MethodInterceptor），通常情况下都是匿名内部类，但不是必须的。
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 指定被代理对象的任何方法都会经过该方法
             * @param o 代理对象的引用
             * @param method 当前代理对象执行的方法
             * @param objects 当前执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 提供增强的代码
                Object result = null;
                // 获取执行方法的参数
                Double money = (Double) objects[0];
                // 判断执行方法的名称
                if ("saleProducts".equals(method.getName())) {
                    result = method.invoke(producer, money * 0.8);
                } else {
                    result = method.invoke(producer, objects);
                }
                return result;
            }
        });
        //生产者卖出产品，代理者收取产品的20%的钱
        cglibProducer.saleProducts(6000.0);
        //代理者售后服务,给多少钱，就收多钱
//        cglibProducer.afterService(1000.0);
    }
}
