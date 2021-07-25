package com.random.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderVo implements Serializable {

	private static final long serialVersionUID = -4390204223840694547L;

	
	private String orderNo;
	
	private BigDecimal orderMoney;
	
	
}
