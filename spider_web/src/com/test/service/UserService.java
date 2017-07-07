package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;
import com.test.common.DBConn2;

public class UserService {
	Connection con;
	PreparedStatement ps;
	String sql;
	public boolean insertUser(HashMap<String, String> hm) {
		con = null;
		ps = null;
		try {
			con = DBConn2.getCon();
			sql = "insert into user_info(id,pwd,name,age,class_num)";
			sql += "values(?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("age"));
			ps.setString(5, hm.get("class_num"));
			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteUser(HashMap<String, String> hm) {
		con = null;
		ps = null;
		try {
			con = DBConn2.getCon();
			sql = "delete from user where num = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("user_num"));
			int result = ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	return false;
}
	public boolean updateUser(HashMap<String, String> hm) {
		con = null;
		ps = null;
		try {
			con = DBConn2.getCon();
			sql = "update user_info ";
			sql+="set name =?,class_num=?,age=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(4, hm.get("user_num"));
			ps.setString(1, hm.get("name"));
			ps.setString(2, hm.get("class_num"));
			ps.setString(3, hm.get("age"));
			int result = ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	return false;
}
	public List<Map> selectUser(HashMap<String, String> hm){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select user_num, user_id, user_pwd, user_name, class_num from user_info";
			if(hm.get("name")!=null){
				sql += " where user_name like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(hm.get("name")!=null){
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while(rs.next()){
				HashMap hm1 = new HashMap();
				hm1.put("user_name", rs.getString("user_name"));
				userList.add(hm1);
			}
			return userList;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}