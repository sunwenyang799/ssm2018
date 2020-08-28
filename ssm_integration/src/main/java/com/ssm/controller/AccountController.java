package com.ssm.controller;

import com.ssm.pojo.Account;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/28 11:11
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/testSpringMvc")
     public String testSpringMvc(Model model){
        List<Account> list = accountService.findAll();
        model.addAttribute("accountList",list);
        return "list";
     }

     @RequestMapping("/saveAccount")
     public void saveAccount(HttpServletRequest request, HttpServletResponse response,Account account) throws IOException {
        accountService.saveAccount(account);
        String url = request.getContextPath()+"/account/testSpringMvc";
        response.sendRedirect(url);
     }
}
