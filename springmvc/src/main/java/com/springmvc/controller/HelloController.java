package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/26 10:44
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(path = "/hello")
     public String hello(){
         System.out.println("Hello SpringMvc");
         return "success";
     }

     @RequestMapping(value = "/testRequestMapping",params = {"username=heihei"},headers = {"authcode=222"})
     public String testRequestMapping(){
        System.out.println("测试requestMapping注解");
        return "success";
     }
}
