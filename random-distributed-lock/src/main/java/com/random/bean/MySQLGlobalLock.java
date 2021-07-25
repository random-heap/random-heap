package com.random.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.random.mapper.GlobalLockMapper;
import com.random.utils.GlobalLockUtil;

@Component
public class MySQLGlobalLock {

	@Resource
	GlobalLockMapper globalLockDAO;

	/**
	 * 尝试获得锁，成功为true，失败为false
	 */
	public boolean tryLock(String key) {
		return GlobalLockUtil.tryLock(this.globalLockDAO, key);
	}

	/**
	 * 如果已经有其他程序占用该锁，并且超过timeoutMs（毫秒）时间，就强制清除这个锁占用 即根据key先删除记录，再添加记录
	 */
	public boolean tryLockWithClear(String key, Long timeoutMs) {
		return GlobalLockUtil.tryLockWithClear(this.globalLockDAO, key, timeoutMs);
	}

	/**
	 * 释放锁，根据key删除记录
	 */
	public void releasLock(String key) {
		GlobalLockUtil.releasLock(this.globalLockDAO, key);
	}

}