package com.spring.ui;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:42 2020/8/20
 * @ Description：测试spring的ioc
 */
public class Client {

    /**
     * 获取spring Ioc核心容器，通过id获取对象
     * ApplicationContext的三个常用实现类(最上级接口为BeanFactory)
     *      ClassPathXmlApplicationContext：加载类路径下的配置文件，要求文件必须在类路径下，不在加载不了
     *      FileSystemApplicationContext：加载磁盘任意路径下的配置文件(必须有访问权限)
     *      AnnotationConfigApplicationContext：读取注解创建容器
     *
     * ApplicationContext：适用于单例模式(因为BeanFactory是父级接口,接口功能没有子接口完善，所以大部分使用ApplicationContext)
     *     构建容器时，创建对象采取的策略是立即加载的方式。也就是说，读取完配置文件马上就创建配置文件中的对象
     * BeanFactory ：适用于多例模式
     *      构建容器时，创建对象采取的策略是延迟加载的方式。什么时候通过id获取对象，什么时候创建对象
     * @param args
     */
    public static void main(String[] args){
        //获取核心容器对象
        //  类路径下读取
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //  磁盘路径下读取
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\ssm2018\\spring_ioc\\src\\main\\resources\\bean.xml");
        // 根据id获取容器中的对象
        //  强转方式
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        //  传入类的字节码方式
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        System.out.println(accountDao);
        System.out.println(accountService);
        
        //----------BeanFactory方式创建容器(该方法已过时)--------------
        /*Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        IAccountDao accountDao1 = beanFactory.getBean("accountDao", IAccountDao.class);
        System.out.println(accountDao1);*/
    }
}
