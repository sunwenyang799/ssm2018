package com.spring.factory;

import com.spring.dao.impl.AccountDaoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author lenovo
 * @description: 工厂模式生产bean
 * @date 2020/8/20 15:16
 *
 * Bean：在计算机语言中，有可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 *          JavaBean  >   实体类
 *    它就是创建dao和service对象的
 *    第一步：需要一个配置文件来配置dao和service
 *              配置文件内容：存储dao和service的全限定类名  唯一标识 = 全限定类名(key = value)
 *    第二步：通过读取配置文件中配置的内容，反射创建对象
 *          配置文件可以是xml也可以是properties
 */
public class BeanFactory {

        private static Properties properties ;

        private  static Properties propertiesService;

        private static Map<String,Object> beanMap = new HashMap<String, Object>() ;

      static {
          //    为什么要读两个文件？
          //    properties为hashtable结构,读取的顺序是随机的,如果先读取到service在读取到dao就会null
           properties = new Properties();
          propertiesService = new Properties();
          //    类加载读取resources根目录下的文件
          InputStream inputStreamDao = BeanFactory.class.getClassLoader().getResourceAsStream("beanDao.properties");
          InputStream inputStreamService = BeanFactory.class.getClassLoader().getResourceAsStream("beanService.properties");
          try {
              properties.load(inputStreamDao);
              propertiesService.load(inputStreamService);
              //    获取配置文件中的所有key
              Enumeration daoKeys = properties.keys();
              Enumeration serviceKeys = propertiesService.keys();
              while(daoKeys.hasMoreElements()){
                  String key = daoKeys.nextElement().toString();
                  //    通过配置文件中的key获取bean的全限定类名
                  String beanPath = properties.getProperty(key);
                  //    通过反射获取全限定类名对象
                  Object bean = Class.forName(beanPath).newInstance();
                  //    封装bean到beanMap中
                  beanMap.put(key,bean);
              }
              while (serviceKeys.hasMoreElements()){
                  String key = serviceKeys.nextElement().toString();
                  //    通过配置文件中的key获取bean的全限定类名
                  String beanPath = propertiesService.getProperty(key);
                  //    通过反射获取全限定类名对象
                  Object bean = Class.forName(beanPath).newInstance();
                  //    封装bean到beanMap中
                  beanMap.put(key,bean);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }

    /**
     * 通过key获取对应的bean(单例模式)
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return beanMap.get(beanName);
    }

    /**
     * 通过beanName获取bean对象(获取的是不同的bean对象,多例模式)
     * @return
     */
//    public static Object getBean(String beanName){
//
//        Object bean = null;
//        String beanPath = String.valueOf(properties.get(beanName));
//        try {
//            bean = Class.forName(beanPath).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bean;
//      }

}
