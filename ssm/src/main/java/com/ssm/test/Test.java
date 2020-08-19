package com.ssm.test;

import java.lang.reflect.Method;

/**
 * @author lenovo
 * @description: 测试
 * @date 2020/8/17 17:50
 */
public class Test {

    public static void main(String[] args){
        {
            try {
                Class<?> aClass = Class.forName("com.ssm.pojo.User");
                String name = aClass.getName();
                System.out.println(name);
                ClassLoader loader = aClass.getClassLoader();
                System.out.println(loader.toString());
                Method[] methods = aClass.getMethods();
                for (Method method : methods) {
                    System.out.println(method.toString());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
