package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:17 2020/8/27
 * @ Description：
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public  String testException(){
        System.out.println("testException执行了");
        int a = 10/0;
        return "success";
    }
}
