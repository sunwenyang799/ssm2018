package com.spring.service.impl;

import com.spring.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 17:15 2020/8/23
 * @ Description：
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    
    public void saveAccount() {
        System.out.println("保存了账户");
//        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("更新了账户");
    }

    public int deleteAccount() {
        System.out.println("删除了账户");
        return 0;
    }
}
