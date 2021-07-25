package com.random.core.entity;

/**
 * 
* @ClassName: TrendlabResult 
* @Description: 请求返回对象
* @Author: yaomaoze@trendlab.ai
* @Date: 2018年9月26日 下午2:23:49
 */
public class TrendlabResult<T> {

	/**
	 * 返回码
	 */
	public int code;

	/**
	 * 返回信息
	 */
	private String message;

	/**
	 * 返回数据
	 */
	private T data;

	public TrendlabResult<T> setCode(TrendlabStatusCode retCode) {
		this.code = retCode.code;
		return this;
	}

	public int getCode() {
		return code;
	}

	public TrendlabResult<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public TrendlabResult<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public TrendlabResult<T> setData(T data) {
		this.data = data;
		return this;
	}

    /**
     * 是否成功
     * @return
     */
	public boolean isSuccess(){
	    return this.code == TrendlabStatusCode.SUCCESS.code;
    }
}
