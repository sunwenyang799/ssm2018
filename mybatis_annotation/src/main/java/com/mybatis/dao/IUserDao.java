package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author lenovo
 * @description: user接口
 * @date 2020/8/19 11:17
 * 注解开发:
 * @Select @Update @Insert @Delete
 */
//开启二级缓存
@CacheNamespace(blocking = true)
public interface IUserDao {

        /**
         * 获取user全部信息,以及对应的account信息(一对多关系)
         * @return
         */
        @Select("select * from t_user")
        @Results(value = {
                @Result(id = true,property = "id",column = "id"),
                @Result(property = "username",column = "username"),
                @Result(property = "adress",column = "adress"),
                @Result(property = "birthday",column = "birthday"),
                @Result(property = "sex",column = "sex"),
                @Result(property = "accountList",column = "id",
                        many =@Many(select = "com.mybatis.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY) )
        })
        List<User> findAll();

        @Insert("insert into t_user(username,birthday,sex,adress) values(#{username},#{birthday},#{sex},#{adress})")
        void SaveUser(User user);

        @Update("update t_user set username = #{username},birthday = #{birthday},sex = #{sex},adress = #{adress} where id = #{id}")
        void UpdateUser(User user);

        @Delete("delete from t_user where id = #{id}")
        void deleteUser(Integer id);

        @Select("select * from t_user where id = #{id}")
        User findUserById(Integer id);

        @Select("select * from t_user where username like #{username}")
//        @Select("select * from t_user where username like '%${value}%'") //注意:${}中必须是value
        List<User> findUserByUsername(String username);

        @Select("select count(*) from t_user")
        int findTotal();
}
