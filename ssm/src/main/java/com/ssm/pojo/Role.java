package com.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author lenovo
 * @description: t_role对应实体类
 * @date 2020/8/18 15:18
 */
public class Role  implements Serializable {

     private Integer roleId;

     private String roleName;

     private String roleDes;

     // role与user多对多关系映射
     private List<User1> userList;

    public List<User1> getUserList() {
        return userList;
    }

    public void setUserList(List<User1> userList) {
        this.userList = userList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDes() {
        return roleDes;
    }

    public void setRoleDes(String roleDes) {
        this.roleDes = roleDes;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDes='" + roleDes + '\'' +
                '}';
    }
}
