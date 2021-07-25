package com.random.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.random.model.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order>  {

}
