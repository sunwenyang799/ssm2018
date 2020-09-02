package com.maven.controller;

import com.maven.pojo.Account;
import com.maven.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/29 14:28
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAccountById")
    public String findAccountById(Model model){
        Account account = accountService.findAccountById(1);
        model.addAttribute("account",account);
        return "success";
    }
}
