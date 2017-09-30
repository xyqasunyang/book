package com.sun.www.result;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月25日
 */
public class ResultEntity {
    private Integer code;
    private String msg;
    private Object obj;

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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ResultEntity(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public ResultEntity() {
        this.code = 0;
    }
}
