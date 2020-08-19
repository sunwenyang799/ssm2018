package com.ssm.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lenovo
 * @description: 使用实现类实现mybatisCURD的pojo  与account的关系为一对多
 * @date 2020/8/17 10:39
 */
public class User1 implements Serializable {

    private Integer id;
    private  String username;
    private Date birthday;
    private String sex;
    private String adress;

    //  一对多关系映射：主表实体应包含从表实体的集合引用
    private List<Account> accountList;

    //  多对多关系映射
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
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

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
