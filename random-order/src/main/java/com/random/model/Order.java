package com.random.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_order")
public class Order implements Serializable {

	private static final long serialVersionUID = -4390204223840694547L;

	private Integer orderId;
	
	private String orderNo;
	
	private BigDecimal orderMoney;
	
	
}
