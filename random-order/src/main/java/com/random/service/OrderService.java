package com.random.service;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.random.core.entity.TrendlabResponse;
import com.random.core.entity.TrendlabResult;
import com.random.coupon.rpc.service.CouponRpcService;
import com.random.mapper.OrderMapper;
import com.random.model.Order;
import com.random.vo.OrderVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@DubboReference(timeout = 1000, check = false, retries = 0)
	private CouponRpcService couponRpcService;

	@Transactional
	public TrendlabResult<String> addOrder(OrderVo orderVo) {
		
		log.info("创建订单, {}", orderVo);
		try {
			Order order = new Order();
			BeanUtils.copyProperties(orderVo, order);
			
			Map<String, Object> resultMap = couponRpcService.lockCoupon("00112233");	
			log.info("锁定优惠券结果：{}", resultMap);
			
			orderMapper.insert(order);
			
		} catch (Exception e) {
			log.error("创建订单失败");
			//回滚数据
			
			return TrendlabResponse.success();
		}
		
		return TrendlabResponse.success();
	}
}
