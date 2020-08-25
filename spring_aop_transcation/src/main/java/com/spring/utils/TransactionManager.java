package com.spring.utils;

import java.sql.SQLException;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:08 2020/8/22
 * @ Description：和事务相关的工具类，包含开启事务，提交事务，事务回滚和释放连接
 */
public class TransactionManager {

    private  ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
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
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//不是关闭线程，而是把线程还回到线程池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
