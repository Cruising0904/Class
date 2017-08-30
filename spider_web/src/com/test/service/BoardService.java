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
import com.test.dto.BoardInfo;

public class BoardService{
	Connection con;
	PreparedStatement ps;
	String sql;
	public boolean insertBoard(BoardInfo bi){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "insert into board(title,content,creusr,reg_date)values(?,?,?,now())";
			ps = con.prepareStatement(sql);
			ps.setString(1, bi.getBiTitle());
			ps.setString(2, bi.getBiContent());
			ps.setString(3, bi.getCreUsr());
						
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
	public boolean deleteBoard(BoardInfo bi){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "delete from board where num =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bi.getdNum());
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
	public boolean updateBoard(BoardInfo bi){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "update board set title=?,content=?,creUsr=? where num =?";
			ps = con.prepareStatement(sql);
			ps.setInt(4, bi.getBiNum());
			ps.setString(1, bi.getBiTitle());
			ps.setString(2, bi.getBiContent());
			ps.setString(3, bi.getCreUsr());
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
	public List<Map> selectBoard(HashMap<String, String> hm1){
		con = null;
		ps = null;
		try {
			con= DBConn2.getCon();
			sql = "select num, title, content, creusr, reg_date from board ";
			if(hm1.get("s_name")!=null){
				sql+=" where user_name like ?";
			}
			ps = con.prepareStatement(sql);
			if(hm1.get("s_name")!=null){
			ps.setString(1, hm1.get("s_name"));
			}
		  ResultSet rs = ps.executeQuery();
		   List boardList = new ArrayList();
		   while(rs.next()){
			   HashMap hm3= new HashMap();
			   hm3.put("num", rs.getString("num"));
			   hm3.put("title", rs.getString("title"));
			   hm3.put("content", rs.getString("content"));
			   hm3.put("writer", rs.getString("writer"));
			   hm3.put("reg_date", rs.getString("reg_date"));
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