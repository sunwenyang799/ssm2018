package com.ssm.mybatis.session;


/**
 * @author lenovo
 * @description:
 * @date 2020/8/14 15:39
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个SqlSession对象
     * */
    SqlSession openSession();
}
