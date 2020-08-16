package com.ssm.dao;

import com.ssm.mybatis.annotations.Select;
import com.ssm.pojo.QueryVo;
import com.ssm.pojo.User;

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

     /**
      * 保存user
      * @param user
      */
     void saveUser(User user);

     /**
      * 更新user
      * @param user
      */
     void updateUser(User user);

     /**
      * 删除user
      * @param id
      */
     void deleteUser(Integer id);

     /**
      * 根据id查询user
      * @param id
      * @return
      */
     User findById(Integer id);

     /**
      * 根据username模糊查询
      * @param username
      * @return
      */
     List<User> findByUsername(String username);

     /**
      * 查询总记录条数
      * @return
      */
     int findTotal();

     /**
      * 根据QueryVo中的username模糊查询
      * @param queryVo
      * @return
      */
     List<User> findByVo(QueryVo queryVo);

}
