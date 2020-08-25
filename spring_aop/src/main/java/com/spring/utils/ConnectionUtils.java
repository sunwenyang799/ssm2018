package com.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:47 2020/8/22
 * @ Description：获取连接的工具类,用于从数据源中获取连接，并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setThreadLocal(ThreadLocal<Connection> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先从ThreadLocal上获取
        Connection connection = threadLocal.get();
        //2.判断当前线程上是否有连接
        if(connection==null){
            //3.没有的话从数据源中获取一个连接，并存入到ThreadLocal中
            try {
                connection = dataSource.getConnection();
            } catch (Exception e) {
                throw  new RuntimeException(e);
            }
            threadLocal.set(connection);
        }
        //4.返回当前线程上的连接
        return connection;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
