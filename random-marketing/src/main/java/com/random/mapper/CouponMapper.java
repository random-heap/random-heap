package com.random.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.random.model.Coupon;

@Mapper
public interface CouponMapper extends BaseMapper<Coupon>  {

	@Update("update t_coupon set coupon_status = #{couponStatus} where coupon_code = #{couponCode}")
	int updateByCode(Coupon coupon);
}
