package com.spring.test;

import com.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lenovo
 * @description: 测试
 * @date 2020/8/25 11:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestTx {

    @Autowired
    private IAccountService accountService;

    @Test
    public void Test(){
        accountService.transfer("aaa","bbb",100.0);
    }
}
