package com.iot1.sql.user.dao;

import java.util.List;
import java.util.Map;

import com.iot1.sql.user.dto.UserInfo;

public interface UserDao {

	UserInfo selectUser(UserInfo pUser);
	List<UserInfo> selectuserList(Map hm);
	
}
