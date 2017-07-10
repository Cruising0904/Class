package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn2;

public class BoardService{
	Connection con;
	PreparedStatement ps;
	String sql;
	public boolean insertBoard(HashMap<String, String> hm){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "insert into board(title,content,writer,reg_date)values(?,?,?,now())";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("writer"));
						
		   int result = ps.executeUpdate();
		   if(result==1){
			   con.commit();
			   return true;
		   }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean deleteBoard(HashMap<String, String> hm){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "delete from board where num ='?'";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("dNum"));
		   int result = ps.executeUpdate();
		   if(result==1){
			   con.commit();
			   return true;
		   }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean updateBoard(HashMap<String, String> hm){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "update board set title='?',content='?',writer='?' where num ='?'";
			ps = con.prepareStatement(sql);
			ps.setString(4, hm.get("bNum"));
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("writer"));
		   int result = ps.executeUpdate();
		   if(result==1){
			   con.commit();
			   return true;
		   }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public List<Map> selectBoard(HashMap<String, String> hm){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "select num, title, content, writer, reg_date from board where num ='?'";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("bNum"));
		  ResultSet rs = ps.executeQuery();
		   List boardList = new ArrayList();
		   while(rs.next()){
			   HashMap hm1= new HashMap();
			   hm1.put("bNum", rs.getString("num"));
			   boardList.add(hm1);
		   }
		   return boardList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
		
}
}