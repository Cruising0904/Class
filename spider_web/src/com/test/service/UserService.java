package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	public boolean selectUser(HashMap<String, String> hm) {
		con = null;
		ps = null;
		List<HashMap> userlist = new ArrayList<HashMap>();
		try {
			con = DBConn2.getCon();
			sql = "select ui.name, ui.id, ui.age, ui.class_num, ci.class_name from user_info as ui,class_info as ci"
					+ "where user_info.name like %?%";
					
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("user_name"));
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				HashMap hm1 = new HashMap();
				int colCount = rsmd.getColumnCount();
				for(int i=1;i<=colCount;i++){
					String colName = rsmd.getColumnName(i);
					hm.put(colName, rs.getString(colName));
				}
				userlist.add(hm);
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
}