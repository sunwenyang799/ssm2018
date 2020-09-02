package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 12:57 2020/8/27
 * @ Description：
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值为String,直接返回页面，返回路径为视图解析器下的页面，通过Model对象在request域中存值取值
     * @param model
     * @return
     */
    @RequestMapping("/testStringResponse")
    public String testStringResponse(Model model){
        System.out.println("testStringResponse执行了");
        User user = new User();
        user.setUsername("swy");
        user.setPassword("123");
        user.setAge(22);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 使用原生Servlet重定向和转发
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("testVoidResponse")
    public void testVoidResponse(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoidResponse执行了");
        //请求转发跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向跳转页面(路径前需要加上项目名)
        //注意：重定向无法访问WEB-INF下的资源
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        //解决中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //不跳转页面，直接响应打印
        response.getWriter().print("你好");
        return;
    }

    /**
     * 使用关键字进行转发和重定向
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect执行了");
        //转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向:无法访问WEB-INF下的资源
        return "redirect:/index.jsp";
    }

    /**
     * ModelAndView：springmvc提供的对象
     * 返回值是ModelAndView,跟返回值是String一样,可以进行页面跳转和传值
     * 通过视图解析器跳转
     * 其实返回值是String跳转页面就是走的ModelAndView的源码
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView执行了");
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("swy");
        user.setPassword("123");
        user.setAge(22);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 返回json格式数据
     * @param user
     * @return
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了");
        user.setUsername("swy111");
        System.out.println(user);
        return  user;
    }
}
