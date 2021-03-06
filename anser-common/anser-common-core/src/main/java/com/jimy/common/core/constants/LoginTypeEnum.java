package com.jimy.common.core.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 第三方登录类型
 */
@Getter
public enum LoginTypeEnum {
	/**
	 * 账号密码登录
	 */
	PWD("PWD", "账号密码登录"),

	/**
	 * 验证码登录
	 */
	SMS("SMS", "验证码登录");

	/**
	 * 类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String description;

	LoginTypeEnum(String type, String description) {
		this.type = type;
		this.description = description;
	}
}
