package com.zy.test.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.test.domain.UserInfo;
import com.zy.test.mapper.UserMapper;
import com.zy.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	public UserInfo findByAccount(String account) {
		return userMapper.findByAccount(account);
	}	
}