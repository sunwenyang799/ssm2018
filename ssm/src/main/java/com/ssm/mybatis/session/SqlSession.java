package com.ssm.mybatis.session;

/**
 * @author lenovo
 * @description:自定义Mybatis中和数据交互的核心类,可以创建dao接口的代理对象
 * @date 2020/8/14 15:40
 */
public interface SqlSession {

    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass  dao的接口字节码  such as  example.class
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     *释放资源
     * */
    void close();
}
