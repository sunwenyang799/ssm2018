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

    /**
     * 事务：是数据库操作的最小工作单元，是作为单个逻辑工作单元执行的一系列操作；这些操作作为一个整体一起向系统提交，要么都执行、要么都不执行；事务是一组不可再分割的操作集合（工作逻辑单元）；
     *
     * 事务的四大特性(ACID)
     * 1 、原子性(Atomicity)
     * 事务是数据库的逻辑工作单位，事务中包含的各操作要么都做，要么都不做
     * 2 、一致性（Consistency）
     * 事务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。因此当数据库只包含成功事务提交的结果时，就说数据库处于一致性状态。如果数据库系统 运行中发生故障，有些事务尚未完成就被迫中断，这些未完成事务对数据库所做的修改有一部分已写入物理数据库，这时数据库就处于一种不正确的状态，或者说是 不一致的状态。
     * 3 、隔离性（Isolation）
     * 一个事务的执行不能其它事务干扰。即一个事务内部的操作及使用的数据对其它并发事务是隔离的，并发执行的各个事务之间不能互相干扰。
     * 4 、持续性（Durability）
     * 也称永久性，指一个事务一旦提交，它对数据库中的数据的改变就应该是永久性的。接下来的其它操作或故障不应该对其执行结果有任何影响。
     *
     * 不考虑隔离性会产生的3个问题
     * 脏读：指当一个事务正字访问数据，并且对数据进行了修改，而这种数据还没有提交到数据库中，这时，另外一个事务也访问这个数据，然后使用了这个数据。因为这个数据还没有提交那么另外一个事务读取到的这个数据我们称之为脏数据。依据脏数据所做的操作肯能是不正确的。
     * 不可重复读：指在一个事务内，多次读同一数据。在这个事务还没有执行结束，另外一个事务也访问该同一数据，那么在第一个事务中的两次读取数据之间，由于第二个事务的修改第一个事务两次读到的数据可能是不一样的，这样就发生了在一个事物内两次连续读到的数据是不一样的，这种情况被称为是不可重复读。
     * 幻象读：一个事务先后读取一个范围的记录，但两次读取的纪录数不同，我们称之为幻象读（两次执行同一条 select 语句会出现不同的结果，第二次读会增加一数据行，并没有说这两次执行是在同一个事务中）
     *
     *解决办法：四种隔离级别
     * 由低到高依次分别为：read uncommited（读未提交）、read commited（读提交）、read repeatable（读重复）、serializable（序列化），这四个级别可以逐个解决脏读、不可重复读、幻读这几类问题。
     * read uncommited：是最低的事务隔离级别，它允许另外一个事务可以看到这个事务未提交的数据。
     * read commited：保证一个事物提交后才能被另外一个事务读取。另外一个事务不能读取该事物未提交的数据。
     * repeatable read：这种事务隔离级别可以防止脏读，不可重复读。但是可能会出现幻象读。它除了保证一个事务不能被另外一个事务读取未提交的数据之外还避免了以下情况产生（不可重复读）。
     * serializable：这是花费最高代价但最可靠的事务隔离级别。事务被处理为顺序执行。除了防止脏读，不可重复读之外，还避免了幻象读。
     *
     *                                  1：可能出现   0：不会出现
     *                             脏读              不可重复读                幻读
     * read uncommited：             1                   1                       1
     * read commited：               0                   1                       1
     * repeatable read：             0                   0                       1
     * serializable：                0                   0                       0
     *
     */

}
