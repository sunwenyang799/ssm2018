package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/21 15:46
 *
 * <bean id = "accountService"  class = "com.spring.service.impl.AccountServiceImpl"  scope = ""  init-method = ""  destroy-method = "">
 *       <property name = "" value = "" /  ref = ""  ></property>
 * </bean>
 *用于创建对象的
 *          xml标签: <bean></bean>
 *          注解：Component：
 *                  作用：用于把当前类对象存入到spring容器中
 *                  属性：value：用于指定bean的id。当我们不写时，它的默认值时当前类名，且首字母小写。
 *                Controller：一般用于表现层
 *                Service：一般用于业务层
 *                Repository：一般用于持久层
 *                以上三个注解他们的作用和属性和Component是一模一样的
 *                他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 * 用于注入数据的
 *              xml标签：<peoperty></peoperty>
 *              注解：Autowired
*                    出现位置：可以是变量上，也可以是方法上
*                    细节：在使用注解注入时，set方法不是必须的
*                    作用：自动按照类型注入。只要容器中有一个唯一bean对象类型和要注入的变量类型匹配，就可以注入成功
*                          如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
*                          如果ioc容器中有多个类型匹配时：
*                    Qualifier:
*                      作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以
*                      属性：value：用于指定注入bean的id。(和Autowired一起用，否则无法注入成功)
*                    Resource
*                          作用：直接按照bean的id注入。它可以独立使用
*                          属性：name：用于指定bean的id。
*                          以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
*                         另外，集合类型的注入只能通过XML来实现。
*                     Value
*                          作用：用于注入基本类型和String类型的数据
*                          属性：value：用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式）
*                               SpEL的写法：${表达式}
*                           El表达式：在jsp中使用的el表达式是jsp的El表达式 取值为四大作用域中
*                                 在Mybatis使用的el表达式是mybatis的EL表达式
*                                 spring中使用的el表达式是spring的EL表达式
 *
 * 用于改变作用范围的
 *            xml标签:bean标签中的scope属性
 *            注解：scope
 *              他们的作用和xml中的scope属性实现功能是一样的
 *             作用：用于指定bean的作用范围
 *             属性：value：指定范围的取值。常用取值：singleton，prototype
 * 和生命周期相关的
 *          xml标签：bean标签中的init-method属性和destroy-method属性
 *          注解：
 *              postConstruct，作用：用于指定初始化的方法
 *              preDestroy，作用：用于指定销毁方法
 */
@Component("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
//    @Resource(name = "accountDao1")
    private IAccountDao accountDao;
    
    public AccountServiceImpl(){
        System.out.println("创建了对象");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化了accountService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁了accountService");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
