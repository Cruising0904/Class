package com.iot.sp.user.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.iot.sp.user.dto.UserInfo;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public UserInfo selectUser(UserInfo user) {
		return user;
		
	}
}
