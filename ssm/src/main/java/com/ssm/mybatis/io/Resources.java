package com.ssm.mybatis.io;

import java.io.InputStream;

/**
 * @author lenovo
 * @description: 使用类加载器读取配置文件
 * @date 2020/8/14 15:34
 */
public class Resources {

    /**
     * 根据传入的参数获取一个字节输入流
     * @return InputStream filePath
     * @param
     * */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);

    }
}
