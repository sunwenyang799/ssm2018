package com.mybatis.pojo;

import java.util.Date;

/**
 * @author lenovo
 * @description: t_user对应实体类(属性与列名不对应)
 * @date 2020/8/19 14:25
 */
public class User1 {

    private   Integer userId;

    private String userAdress;

    private String userSex;

    private String userName;

    private Date userBirthday;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
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

    @Override
    public String toString() {
        return "User1{" +
                "userId=" + userId +
                ", userAdress='" + userAdress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }
}
