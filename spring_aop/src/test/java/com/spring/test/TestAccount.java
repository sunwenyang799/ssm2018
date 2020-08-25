package com.spring.test;

import com.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:28 2020/8/22
 * @ Description：
 */
@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccount {

    @Autowired
    //使用代理的accountService
    @Qualifier("accountServiceBean")
    private IAccountService accountService;

    @Test
    public void TestTransfer(){
        accountService.transfer("aaa","bbb",100.0);
    }
}
