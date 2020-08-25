package com.spring.ui;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lenovo
 * @description: bean的生命周期
 * @date 2020/8/21 10:54
 */
public class BeanInitAndDestroyClient {

    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
        accountDao.saveAccount();
        //  单例对象可以主动销毁对象、多例对象不可以(由java的垃圾回收器进行回收)
        //  销毁容器(当容器被销魂时,无法在通过这个spirng容器创建对象)
        ((ClassPathXmlApplicationContext) applicationContext).close();


        //------------------------当容器被销毁是，无法创建单例对象---------------------------------
//        IAccountDao accountDao1 = applicationContext.getBean("accountDao", IAccountDao.class);
//        accountDao.saveAccount();
//        ((ClassPathXmlApplicationContext) applicationContext).close();

        //------------------------当容器被销毁是，也无法创建多例对象----------------------------
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
    }
}
