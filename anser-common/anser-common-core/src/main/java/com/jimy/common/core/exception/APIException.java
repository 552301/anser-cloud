package com.jimy.common.core.exception;

import lombok.Data;

/**
 * @Author: jimy
 * @Date: 2020/4/12 15:40
 * @Description:只要getter方法，无需setter
 */
@Data
public class APIException extends RuntimeException {

    /**
     * 接口异常代码
     */
    private int code;

    /**
     * 接口异常消息
     */
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}