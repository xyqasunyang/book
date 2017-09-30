package com.sun.www.exception;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月25日
 */
public class SunException extends Exception {

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SunException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SunException() {
    }

}
