package com.random.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.random.bean.MySQLGlobalLock;
import com.random.core.entity.TrendlabResponse;
import com.random.core.entity.TrendlabResult;

@Service
public class MySQLGlobalLockService {

	@Autowired
	private MySQLGlobalLock mySQLGlobalLock;
	
	@Transactional
	public TrendlabResult<String> lock(String key) {
		
		boolean lockFlag = mySQLGlobalLock.tryLock(key);
		if (!lockFlag) {
			return TrendlabResponse.error("获取锁失败");
		}
		
		return TrendlabResponse.success();
	} 
	
	@Transactional
	public TrendlabResult<String> unlock(String key) {
		
		mySQLGlobalLock.releasLock(key);
		
		return TrendlabResponse.success();
	} 
}
