package com.spring.cglib;

import com.spring.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:34 2020/8/23
 * @ Description：cglib实现基于接口的动态代理
 */
public class CglibInterfaceClient {

    public static void main(String[] args){
       final Producer producer = new Producer();
        IProducer producerProxy = (IProducer) Enhancer.create(producer.getClass(), producer.getClass().getInterfaces(), new MethodInterceptor() {
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

        producerProxy.saleProducts(10000.0);
    }
}
