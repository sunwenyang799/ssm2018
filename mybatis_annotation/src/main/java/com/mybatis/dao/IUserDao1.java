package com.mybatis.dao;

import com.mybatis.pojo.User1;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lenovo
 * @description: User1接口dao(属性与列名不一致)
 * @date 2020/8/19 14:27
 */
public interface IUserDao1 {

    @Select("select * from t_user")
    //  处理实体类属性与数据库类名不一致问题
    //  id:唯一标识，可以被其他方法直接调用
    @Results(id ="userMap",value ={
            @Result(id = true ,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(property = "userAdress",column = "adress"),
            @Result(property = "userBirthday",column = "birthday"),
            @Result(property = "userSex",column = "sex")
    })
    List<User1> findAll();

    //  @ResultMap(value = {"userMap"}) 标准写法，当注解只有一个属性时,value可省略,当数组中只有一个值时，{}可以省略
    @Insert("insert into t_user(username,birthday,sex,adress) values(#{username},#{birthday},#{sex},#{adress})")
    @ResultMap(value = {"userMap"})
    void SaveUser(User1 user);

    @Update("update t_user set username = #{username},birthday = #{birthday},sex = #{sex},adress = #{adress} where id = #{id}")
    @ResultMap(value = {"userMap"})
    void UpdateUser(User1 user);

    @Delete("delete from t_user where id = #{id}")
    @ResultMap(value = {"userMap"})
    void deleteUser(Integer id);

    @ResultMap("userMap")
    @Select("select * from t_user where id = #{id}")
    User1 findUserById(Integer id);

    @Select("select * from t_user where username like #{username}")
    @ResultMap(value = {"userMap"})
//        @Select("select * from t_user where username like '%${value}%'") //注意:${}中必须是value
    List<User1> findUserByUsername(String username);

    @Select("select count(*) from t_user")
    @ResultMap(value = {"userMap"})
    int findTotal();
}
