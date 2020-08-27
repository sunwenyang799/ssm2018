package com.springmvc.exception;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:33 2020/8/27
 * @ Description：自定义异常类
 */
public class SysException extends Exception{

    private String errMsg;

    public SysException(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
