package com.spring.factory;

import com.spring.service.IAccountService;
import com.spring.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:01 2020/8/23
 * @ Description：生产可以控制事务的AccountService
 */
public class BeanFactory {

    private IAccountService accountService;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 生产可以控制事务的accountService
     * @return
     */
    public IAccountService getAccountService(){

        IAccountService accountServiceProxy = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            result =  method.invoke(accountService, args);
                            //3.提交事务
                            transactionManager.commit();
                        } catch (Exception e) {
                            //4.事务回滚
                            transactionManager.rollback();
                        } finally {
                            //5.释放资源
                            transactionManager.release();
                        }
                        return result;
                    }
                });
        return accountServiceProxy;
    }
}
