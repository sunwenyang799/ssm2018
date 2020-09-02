package com.springmvc.controller;

import com.springmvc.pojo.Account;
import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lenovo
 * @description: 请求参数
 * @date 2020/8/26 14:11
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 当所传参数较少时，可以直接定义方法变量接收参数(键值对形式)
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/testParam1",method = RequestMethod.POST)
    public String testParam1(String username,String password, HttpServletRequest request){
        System.out.println("执行了testParam1");
        System.out.println(username);
        System.out.println(password);
        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        return  "success";
    }

    /**
     * 当所传参数较多时，可以通过封装实体来接收参数
     * @param account
     * @return
     */
    @RequestMapping(value = "/saveAccount",method = RequestMethod.POST)
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    /**
     *请求参数自定义类型转换
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 获取Servlet原生API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getServletAPI",method = RequestMethod.POST)
    public String getServletAPI(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(request.getHeader("authcode"));
        return "success";
    }

}
