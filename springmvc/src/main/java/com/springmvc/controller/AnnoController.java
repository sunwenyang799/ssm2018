package com.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @author lenovo
 * @description: 注解
 * @date 2020/8/26 16:47
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
//SessionAttributes把当前request中的值存到session中,注解只能在类上
public class AnnoController {

    /**
     * RequestParam注解：默认必填,不传报错，传的参数名必须和value值一样,参数名随便
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
     public  String testRequestParam(@RequestParam(value = "name") String username){
         System.out.println(username);
         return "success";
     }

    /**
     * RequestBody注解,获取请求体  username=aaa&password=111 多用于传递json格式参数
     * @param value
     * @return
     */
     @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
     public String testRequestBody(@RequestBody String value){
        System.out.println(value);
         JSONObject jsonObject = JSONObject.parseObject(value);
         String username = jsonObject.getString("username");
         System.out.println(username);
         return "success";
     }

    /**
     * PathVariable注解，路径中使用占位符，适用于restful风格接口
     * @param id
     * @return
     */
     @RequestMapping("/testPathVariable/{id}")
     public String testPathVariable(@PathVariable(value = "id") String id){
         System.out.println(id);
         return "success";
     }

    /**
     * RequestHeader：获取请求头信息，value值为header的key
     * @param header
     * @return
     */
     @RequestMapping("/testRequestHeader")
     public String testRequestHeader(@RequestHeader(value = "Accept") String header){
            System.out.println(header);
            return "success";
     }

    /**
     * 获取cookie的ISESSIONID的值
     * @param cookieValue
     * @return
     */
     @RequestMapping("/testCookieValue")
     public String testCookieValue(@CookieValue(value = "JSESSIONID")String cookieValue){
         System.out.println(cookieValue);
         return "success";
     }

    /**
     * ModelAttribute：方法上有这个注解，会在controller每个方法执行之前执行
     *
     * @param user
     * @return
     */
     @RequestMapping("/testModeAttribute")
     public String testModeAttribute(@ModelAttribute("user") User user){
         System.out.println("testModeAttribute方法执行了");
         System.out.println(user);
         return "success";
     }
    /**
     * 有返回值的方法，返回值直接作为接口的参数使用
     */
    /**
     /*@ModelAttribute
     public User modeAttribute(String username,String password){
         System.out.println("modeAttribute方法执行了");
         User user = new User();
         user.setUsername("嘿嘿嘿");
         user.setPassword("222");
         user.setBirthday(new Date());
         return user;
     }*/

    /**
     * 无返回值得方法，要在参数中定义一个Map,然后把值存入到Map中，接口通过在参数上加
     * ModelAttribute注解通过Map中的key取出值
     */
//     @ModelAttribute
//     public void modeAttribute(String username,String password,Map<String,User> userMap){
//         System.out.println("modeAttribute方法执行了");
//         User user = new User();
//         user.setUsername("嘿嘿嘿");
//         user.setPassword("222");
//         user.setBirthday(new Date());
//         userMap.put("user",user);
//     }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/setSessionAttributes")
    public String setSessionAttributes(Model model){
        model.addAttribute("msg","request域中存值");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        //取出session值
        String msg = (String) modelMap.get("msg");
        System.out.println("取出session的值为："+msg);
        return "success";
    }

    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status){
        //会话完成，清空session值
        status.setComplete();
        System.out.println("会话完成，session清空");
        return "success";
    }
}
