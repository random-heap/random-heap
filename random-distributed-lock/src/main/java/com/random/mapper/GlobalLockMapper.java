package com.random.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.random.model.GlobalLock;

@Mapper
public interface GlobalLockMapper {

	int deleteByPrimaryKey(Integer id);

	int deleteByLockKey(String lockKey);

	GlobalLock selectByLockKey(String key);

	int insertSelectiveWithTest(GlobalLock record);
}
