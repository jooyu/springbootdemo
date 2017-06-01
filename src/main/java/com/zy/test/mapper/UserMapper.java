package com.zy.test.mapper;

import org.apache.ibatis.annotations.Select;

import com.zy.test.domain.UserInfo;

public interface UserMapper {

	@Select("select *from t_user where account=#{account}")
	UserInfo findByAccount(String account);
}
