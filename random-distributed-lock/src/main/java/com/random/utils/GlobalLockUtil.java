package com.random.utils;

import java.util.Date;

import com.random.mapper.GlobalLockMapper;
import com.random.model.GlobalLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalLockUtil {

	private static GlobalLock tryLockInternal(GlobalLockMapper lockDAO, String key) {
		
		GlobalLock insert = new GlobalLock();
		insert.setCreateTime(new Date());
		insert.setLockKey(key);
		// 注意的地方1
		int count = lockDAO.insertSelectiveWithTest(insert);
		if (count == 0) {
			GlobalLock ready = lockDAO.selectByLockKey(key);
			log.warn("can not lock the key: {}, {}, {}", insert.getLockKey(), ready.getCreateTime(), ready.getId());
			return ready;
		}
		log.info("yes got the lock by key: {}", insert.getId(), insert.getLockKey());
		
		return null;
	}

	/** 超时清除锁占用，并重新加锁 **/
	public static boolean tryLockWithClear(GlobalLockMapper lockDAO, String key, Long timeoutMs) {
		GlobalLock lock = tryLockInternal(lockDAO, key);
		if (lock == null)
			return true;
		if (System.currentTimeMillis() - lock.getCreateTime().getTime() <= timeoutMs) {
			log.warn("sorry, can not get the key. : {}, {}, {}", key, lock.getId(), lock.getCreateTime());
			return false;
		}
		log.warn("the key already timeout wthin : {}, {}, will clear", key, timeoutMs);
		// 注意的地方2
		int count = lockDAO.deleteByPrimaryKey(lock.getId());
		if (count == 0) {
			log.warn("sorry, the key already preemptived by others: {}, {}", lock.getId(), lock.getLockKey());
			return false;
		}
		lock = tryLockInternal(lockDAO, key);
		return lock != null ? false : true;
	}

	/** 加锁 **/
	public static boolean tryLock(GlobalLockMapper lockDAO, String key) {
		return tryLockInternal(lockDAO, key) == null ? true : false;
	}

	/** 解锁 **/
	public static void releasLock(GlobalLockMapper lockDAO, String key) {
		lockDAO.deleteByLockKey(key);
	}
}
