package com.random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.random.core.entity.TrendlabResult;
import com.random.service.MySQLGlobalLockService;

@RestController
@RequestMapping("/random/v1")
public class MySQLGlobalLockController {

	@Autowired
	private MySQLGlobalLockService mySQLGlobalLockService;
	
	@GetMapping("/db/lock")
	public TrendlabResult<String> lock(@RequestParam String key) {
		return mySQLGlobalLockService.lock(key);
	} 
	
	@GetMapping("/db/unlock")
	public TrendlabResult<String> unlock(@RequestParam String key) {
		return mySQLGlobalLockService.unlock(key);
	} 
}
