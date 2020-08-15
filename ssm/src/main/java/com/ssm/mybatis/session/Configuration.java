package com.ssm.mybatis.session;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lenovo
 * @description: 配置文件信息
 * @date 2020/8/14 17:07
 */
public class Configuration {

    private String driver;

    private String url;

    private String username;

    private String password;

    private Map<String,Mapper> mappers = new HashMap<>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    //  读取配置mapper是追加的,不能set会覆盖
    public void setMappers(Map<String, Mapper> mappers) {
         this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
