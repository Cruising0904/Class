package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.DBConn2;

public class Connect {
	Connection con;
	
	
	public void setConnect() throws ClassNotFoundException, SQLException {
		con = DBConn2.getCon();
	}

	public boolean insertBoard() {
		String sql = "insert into board(title, content, writer, reg_date) values('testestest','non_exist',2,now())";
		try {
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				return true;
			}
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateBoard(){
		String sql = "update board set title ='으하하하' where num = '5'";
		try{
		Statement st = con.createStatement();
		int result = st.executeUpdate(sql);
		if (result == 1) {
			con.commit();
			st.close();
			st = null;
			return true;
		}
		}catch(Exception e){
			try{
				con.rollback();
			}catch(SQLException e1){
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteBoard(){
		String sql="delete from board where num>'5'";
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result ==1){
				con.commit();
				st.close();
				st = null;
				return true;
			}
			}catch(Exception e){
				try{
					con.rollback();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
			return false;
		}
	public List<HashMap> selectBoard(){
		List<HashMap> userlist = new ArrayList<HashMap>();
	String sql="select *from where board";
	
	try{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()){
			HashMap hm = new HashMap();
			int colCount = rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++){
				String colName = rsmd.getColumnName(i);
				hm.put(colName, rs.getString(colName));
			}
			userlist.add(hm);
		}
		DBConn2.closeCon();
		return userlist;
	}catch(Exception e){
		try{
			con.rollback();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	return null;
	}
	
	}
