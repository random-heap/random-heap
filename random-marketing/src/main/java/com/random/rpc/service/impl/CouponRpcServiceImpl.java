package com.random.rpc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.random.coupon.rpc.service.CouponRpcService;
import com.random.mapper.CouponMapper;
import com.random.model.Coupon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService
public class CouponRpcServiceImpl implements CouponRpcService {

	@Autowired
	private CouponMapper couponMapper;
	
	@Transactional
	@Override
	public Map<String, Object> lockCoupon(String couponId) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		log.info("锁定优惠券");
		
		Coupon coupon = new Coupon();
		coupon.setCouponCode(couponId);
		coupon.setCouponStatus("L");
		
		couponMapper.updateByCode(coupon);
		
		return resultMap;
	}

}
