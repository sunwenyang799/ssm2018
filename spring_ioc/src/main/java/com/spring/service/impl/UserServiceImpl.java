package com.spring.service.impl;

import com.spring.service.IUserService;

import java.util.Date;

/**
 * @author lenovo
 * @description: IUserService实现类, 用于DI
 * @date 2020/8/21 13:49
 */
public class UserServiceImpl implements IUserService {

    private String name;
    private String sex;
    private Integer age;
    private Date birthday;

    //  构造函数依赖注入
   /* public UserServiceImpl(String name,String sex,Integer age,Date birthday){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }*/

   //   set方法依赖注入
    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveUser() {
        System.out.println("保存了用户"+name+","+sex+","+age+","+birthday);
    }
}
