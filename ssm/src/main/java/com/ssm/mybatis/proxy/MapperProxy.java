package com.ssm.mybatis.proxy;

import com.ssm.mybatis.session.Mapper;
import com.ssm.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @ Author     ：swy.
 * @ Date       ：Created in 14:53 2020/8/15
 * @ Description：
 */
public class MapperProxy implements InvocationHandler {

    //  map的key是全限定类型加方法名
    private  Map<String,Mapper> mappers;

    private Connection connection;

    public  MapperProxy(Map<String, Mapper> mappers,Connection connection){
        this.mappers = mappers;
        this.connection = connection;
    }

    /**
    *用于对方法进行增强，我们的增强实际上就是调用selectList方法
     * @param proxy 代理对象的引用
     * @param method 当前执行的方法
     * @param args 当前执行方法所需要的参数
     * @return 和被代理对象具有相同的返回值
     * @throws Throwable
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //  1.获取方法名
        String methodName = method.getName();
        //  2.获取方法所在类的名称
        String  className = method.getDeclaringClass().getName();
        //  3.获取key
        String key = className + "." + methodName;
        //  4.获取mapper中的mapper对象
        Mapper mapper  = mappers.get(key);
        // 5.判断是否有mapper
        if (mapper==null){
            throw  new IllegalArgumentException("传入的参数有误");
        }
        // 6.调用查询方法
        return new Executor().selectList(mapper,connection);
    }
}
