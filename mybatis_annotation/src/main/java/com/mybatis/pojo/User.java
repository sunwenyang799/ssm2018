package com.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lenovo
 * @description: t_user实体类
 * @date 2020/8/19 11:15
 */
public class User implements Serializable {

    private Integer id;

    private  String username;

    private Date birthday;

    private String sex;

    private String adress;

    //  一对多关系映射
    private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    //  不重写toString打印地址
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", birthday=" + birthday +
//                ", sex='" + sex + '\'' +
//                ", adress='" + adress + '\'' +
//                '}';
//    }
}
