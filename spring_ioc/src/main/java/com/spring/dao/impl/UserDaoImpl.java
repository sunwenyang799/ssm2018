package com.spring.dao.impl;

import com.spring.dao.IUserDao;

import java.util.*;

/**
 * @author lenovo
 * @description: IUserDao实现类
 * @date 2020/8/21 13:47
 */
public class UserDaoImpl implements IUserDao {

    private List<String> myList;
    private String[] myStr;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void saveUser() {
//        System.out.println(myStr);
        //  数组打印要用这个方法,否则会打印数组的地址
        System.out.println(Arrays.toString(myStr));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }
}
