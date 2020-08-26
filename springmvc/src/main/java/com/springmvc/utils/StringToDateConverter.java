package com.springmvc.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenovo
 * @description: 自定义String类型转换为Date类型
 * @date 2020/8/26 15:57
 *
 * 实现Converter类，
 *  Converter<String,Date> String:传入的数据，Date：需要转换到什么样的数据类型
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
       if(StringUtils.isEmpty(source)){
           throw new RuntimeException("请输入日期数据");
       }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("日期转换出错");
        }
    }
}
