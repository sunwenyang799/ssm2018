package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 15:00 2020/8/23
 * @ Description：基于接口的动态代理实现
 */
public class InterfaceProxyClient {

    public static void main(String[] args){
        final Producer producer = new Producer();
        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法进行增加
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *  如何创建代理对象
         *      使用Proxy类中的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理类至少实现一个接口，如果没有则不能用
         *   newProxyInstance方法参数：
         *      ClassLoader：类加载器
         *      它用于加载代理对象字节码的，和被代理对象使用相同的类加载器。固定写法
         *      class[]:字节码数组
         *      它是让被代理对象和代理对象有相同的方法。固定写法
         *      InvocationHandler：用于提供增强的代码
         *      它让我们写如何实现代理。我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         */
        IProducer producerProxy = (IProducer) Proxy.newProxyInstance(Producer.class.getClassLoader(), Producer.class.getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * @param proxy  代理对象的引用
             * @param method 当前代理对象执行的方法
             * @param args 当前执行方法所需要的参数
             * @return 和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 提供增强的代码
                Object result = null;
                // 获取执行方法的参数
                Double money = (Double) args[0];
                // 判断执行方法的名称
                if("saleProducts".equals(method.getName())){
                    result= method.invoke(producer,money*0.8);
                }else{
                    result = method.invoke(producer,args);
                }
                return  result;
            }
        });
        //生产者卖出产品，代理者收取产品的20%的钱
        producerProxy.saleProducts(6000.0);
        //代理者售后服务,给多少钱，就收多钱
//        producerProxy.afterService(1000.0);

    }
}
