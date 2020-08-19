package com.mybatis.pojo;

import java.io.Serializable;

/**
 * @author lenovo
 * @description: t_account对应实体类
 * @date 2020/8/19 14:48
 */
public class Account implements Serializable {

    private Integer id;

    private Integer uid;

    private Double money;

    //  多对一映射(mybatis中称为一对一)：多(一)个账户属于一个用户
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}



