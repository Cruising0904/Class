package com.iot.sp.user.dao;

import java.util.List;
import java.util.Map;

import com.iot.sp.user.dto.UserInfo;

public interface UserDao {

	public UserInfo selectUser(UserInfo pUser);
	public List<UserInfo> selectUserList(Map hm);

}
