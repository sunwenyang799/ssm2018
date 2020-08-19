package com.ssm.dao;

import com.ssm.pojo.Role;

import java.util.List;

/**
 * @author lenovo
 * @description: role对应接口dao
 * @date 2020/8/18 15:19
 */
public interface IRoleDao {

    /**
     * 查询所有角色信息
     */
    List<Role> findAll();
}
