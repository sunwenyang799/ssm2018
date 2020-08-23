package com.spring.proxy;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 14:59 2020/8/23
 * @ Description：生产厂家接口
 */
public interface IProducer {

    /**
     * 出售产品
     * @param money
     */
    public void saleProducts(Double money);

    /**
     * 售后
     * @param money
     */
    public void afterService(Double money);

}
