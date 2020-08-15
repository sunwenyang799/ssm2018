package com.ssm.mybatis.session;

/**
 * @author lenovo
 * @description: 用于封装执行的Sql语句和结果类型的全限定类名
 * @date 2020/8/14 17:12
 */
public class Mapper {

    private  String queryString;//sql语句

    private String resultType;//结果类型的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
