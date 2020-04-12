package com.jimy.common.core.enums;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.gateway.entity
 * @date 2020-03-31 10:26
 **/
public enum ResultCodeEnum {

    SUCCESS(10000, "操作成功"),

    FAILED(10001, "响应失败"),

    VALIDATE_FAILED(10002, "参数校验失败"),

    ERROR(5000, "未知错误"),

    SGIN_EMPTY(10003, "sgin is empty"),

    SIGN_INVALID(10004, "sign is invalid"),

    PUBLICKEY_EMPTY(10005, "public key is empty"),

    PRIVATEKEY_EXPIRE(10006, "private key 过期");

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

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
