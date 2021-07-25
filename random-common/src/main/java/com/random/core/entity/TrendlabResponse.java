package com.random.core.entity;

/**
 * 
* @ClassName: TrendlabResponse 
* @Description: 项目请求响应类
* @Author: yaomaoze@trendlab.ai
* @Date: 2018年9月26日 下午2:22:59
 */
public class TrendlabResponse<T> {

	private final static String SUCCESS = "success";
	
	private final static String FAIL = "fail";

	public static <T> TrendlabResult<T> success() {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.SUCCESS).setMessage(SUCCESS);
	}
	
	public static <T> TrendlabResult<T> success(T data) {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.SUCCESS).setMessage(SUCCESS).setData(data);
	}
	
	public static <T> TrendlabResult<T> success(String message, T data) {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.SUCCESS).setMessage(message).setData(data);
	}

	public static <T> TrendlabResult<T> error() {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.FAIL).setMessage(FAIL);
	}
	
	public static <T> TrendlabResult<T> error(String message) {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.FAIL).setMessage(message);
	}

	public static <T> TrendlabResult<T> error(T data) {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.FAIL).setMessage(FAIL).setData(data);
	}
	
	public static <T> TrendlabResult<T> error(String message, T data) {
		return new TrendlabResult<T>().setCode(TrendlabStatusCode.FAIL).setMessage(message).setData(data);
	}
	
	public static <T> TrendlabResult<T> response(int code, String msg) {
		return new TrendlabResult<T>().setCode(code).setMessage(msg);
	}

	public static <T> TrendlabResult<T> response(int code, String msg, T data) {
		return new TrendlabResult<T>().setCode(code).setMessage(msg).setData(data);
	}

}
