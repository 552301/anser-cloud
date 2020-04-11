package com.jimy.gateway.entity;

import lombok.Data;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.gateway.entity
 * @date 2020-03-31 10:26
 **/
public enum ResultCodeEnum {

    SGIN_EMPTY("10001","sgin is empty"),
    SIGN_INVALID("10002","sign is invalid"),
    PUBLICKEY_EMPTY("10003","public key is empty"),
    PRIVATEKEY_EXPIRE("10004","private key 过期");

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
