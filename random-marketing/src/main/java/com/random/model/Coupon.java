package com.random.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_coupon")
public class Coupon implements Serializable {

	private static final long serialVersionUID = -8682726721839587438L;

	private Integer couponId;
	
	private String couponCode;
	
	private String couponStatus;
	
}
