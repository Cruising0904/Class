package com.iot.sp.user.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.sp.user.dao.UserDao;
import com.iot.sp.user.service.UserService;

public class UserInfo {
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public UserInfo getUser(UserInfo pUser) {
		UserInfo user = (UserInfo) userDao.selectUser(pUser);
		return user;
	}
}
}
