package com.ssm.dao;

import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lenovo
 * @version 1.0
 * @description:
 * @date 2020/8/13 16:55
 */
public interface IUserDao {

//     @Select("select * from t_user")
     List<User> findAll();
}
