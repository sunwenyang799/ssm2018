package com.ssm.mybatis;

/**
 * @author lenovo
 * @description: 笔记
 * @date 2020/8/17 9:47
 */
public class note {

    /**
     * 一般的jdk动态代理是必须要实现类的，翻看网上的很多文章都在说mybatis 也是用了JDK动态代理，但是mabatis 并没有实现类，这不是有矛盾吗？
     *
     * 其实答案很简单，mybatis确实使用了JDK动态代理，但是他并不需要调用实现类的方法，之前我们说的JDk动态代理，因为最后都会调用实现类里的方法，所以才需要实现类，但是mybatis 根本不需要调用实现类方法，，
     * 注意看这个MapperProxy类里的invoke的实现，之前我们说的动态代理，执行代理类invoke这个方法的时候，是会去执行实现类里的方法，但是mybatis的代理类中的这个，是不需要实现类的方法的，姿势通过一系列拼装，去执行了jdbc  ,所以mybatis没有实现类，但还是看做一个JDK动态，其实我觉得也不算严格意义的JDK动态代理
     *
     */

    /**
     * session执行crud方法一直到获取preparedStatement执行excute()方法所用到的类
     * DefaultSqlSession implements Sqlsession
     * CachingExcutor implements Executor
     * BaseExcutor implements Excutor
     *SimpleExecutor extends BaseExecutor
     * RoutingStatementHandler implements StatementHandler
     * PreparedStatementHandler extends BaseStatementHandler
     */

    /**
     * 写实现类源码分析：
     * 通过sqlsessionfactory获取到session之后
     * 通过sqlsession调用对应的方法
     * 例如：查询全部 selectList
     *       查询一个 selectOne
     *     最终获取到preparedStatement之后调用excute()方法来进行JDBC的操作(这里也对JDBC赋值取值进行了封装)
     */

    /**
     * 直接调用接口源码分析：
     * 通过获取sqlsession之后
     * 调用getMapper方法将sqlSession传入Configuration中
     * 通过Configuration的getMapper将sqlSession传入MapperRegistry
     * 通过MapperRegistry  newInstance(SqlSession sqlSession)将sqlSession填充到MapperProxy中
     * 通过MapperRegistry   newInstance(MapperProxy<T> mapperProxy) 创建接口的代理对象
     * 调用接口方法自动调用invoke方法执行其中的excute()方法
     * 在excute()通过mapper来判断调用 sqlSession的query还是update方法
     * 方法执行过程与实现类获取到preparedStatement之后调用excute()一致
     */

}
