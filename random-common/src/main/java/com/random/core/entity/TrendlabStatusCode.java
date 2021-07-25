package com.random.core.entity;

/**
 * 
* @ClassName: TrendlabStatusCode 
* @Description: 状态码枚举类 
* @Author: yaomaoze@trendlab.ai
* @Date: 2018年9月26日 下午2:24:40
 */
public enum TrendlabStatusCode {

	// 成功
	SUCCESS(200),

	// 失败
	FAIL(400),

	// 未认证（签名错误）
	UNAUTHORIZED(401),

	// 接口不存在
	NOT_FOUND(404),

	// 服务器内部错误
	INTERNAL_SERVER_ERROR(500),
	
	// 重新登录
	RELOGIN(407);

	public Integer code;
	
	TrendlabStatusCode(int code) {
		this.code = code;
	}

}
