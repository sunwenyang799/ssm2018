package com.ssm.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author lenovo
 * @version 1.0
 * @description: TODO
 * @date 2020/8/13 16:43
 */
public class User implements Serializable {

    private Integer userId;
    private  String userName;
    private Date userBirthday;
    private String userSex;
    private String userAdress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBirthday=" + userBirthday +
                ", userSex='" + userSex + '\'' +
                ", userAdress='" + userAdress + '\'' +
                '}';
    }
}
