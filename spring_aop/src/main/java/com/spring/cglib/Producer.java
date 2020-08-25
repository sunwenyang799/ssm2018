package com.spring.cglib;

import com.spring.proxy.IProducer;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 14:57 2020/8/23
 * @ Description：一个生产厂家
 */
public class Producer implements IProducer {

    /**
     * 出售产品
     * @param money
     */
    public void saleProducts(Double money){
        System.out.println("卖出了产品，获得了"+money+"元");
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(Double money){
        System.out.println("收到了"+money+"元用来售后服务解决产品问题");
    }
}
