package com.ssm.pojo;

import java.io.Serializable;

/**
 * @author lenovo
 * @description: t_account实体类  与user关系为一对一
 * @date 2020/8/18 11:27
 */
public class Account implements Serializable {

    private Integer id;

    private Integer uid;

    private  Double money;

    // 一对一关系映射
    private User1 user;

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

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
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
