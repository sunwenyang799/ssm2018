package com.ssm.pojo;

import java.io.Serializable;

/**
 * @author lenovo
 * @description: Acount子类用于封装Account和User字段
 * @date 2020/8/18 13:33
 */
public class AcountUser extends Account implements Serializable {
    private String username;

    private String sex;

    private String adress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return super.toString()+"AcountUser{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
