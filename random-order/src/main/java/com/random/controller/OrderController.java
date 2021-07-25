package com.random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.random.core.entity.TrendlabResult;
import com.random.service.OrderService;
import com.random.vo.OrderVo;

@RestController
@RequestMapping("/random/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public TrendlabResult<String> addOrder(@RequestBody OrderVo orderVo) {
		return orderService.addOrder(orderVo);
	}
}
