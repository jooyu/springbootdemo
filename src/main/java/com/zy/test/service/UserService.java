package com.zy.test.service;

import com.zy.test.domain.UserInfo;

public interface UserService {
	
	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	UserInfo findByAccount(String account);
}
