package com.random.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GlobalLock implements Serializable {

	private static final long serialVersionUID = 3859364992547334562L;

	private Integer id;

	private String lockKey;

	private Date createTime;
}
