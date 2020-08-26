package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lenovo
 * @description:
 * @date 2020/8/26 14:57
 */
public class User implements Serializable {

    private String username;
    private String password;
    private Date birthday;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

