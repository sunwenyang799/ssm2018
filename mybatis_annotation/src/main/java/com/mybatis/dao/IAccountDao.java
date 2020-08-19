package com.mybatis.dao;

import com.mybatis.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author lenovo
 * @description: Account接口dao
 * @date 2020/8/19 15:03
 */
public interface IAccountDao {

    /**
     * 获取全部account信息,以及对应的user信息
     * @return
     */
    @Select("select * from t_account")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property =  "uid" ,column = "uid"),
            @Result(property = "money",column = "money"),
            //  一对一关系映射,一对一采用立即加载
            @Result(property = "user",column = "uid",one=@One(select = "com.mybatis.dao.IUserDao.findUserById",fetchType = FetchType.EAGER))
    })
     List<Account> findAll();

    /**
     * 根据uid获取account信息
     * @param uid
     * @return
     */
    @Select("select * from t_account where uid = #{uid}")
    List<Account> findAccountByUid(Integer uid);
}
