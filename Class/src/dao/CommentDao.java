package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Common.DBConn2;

public class CommentDao {
	Connection con;
	DBConn2 db = new DBConn2();
	public void setConnect() throws ClassNotFoundException, SQLException {
		con = DBConn2.getCon();
	}

	public boolean insertComment(){
		String sql = "insert into Comment_info(content, reg_date, B_num,UI_num)values('냉무',now(),auto_increment,1) ";
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
				e1.printStackTrace();
			}
		}finally{
			try{
			db.closeCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
		}
	public static void main(String[] args){
		CommentDao cd = new CommentDao();
		cd.insertComment();
	}
}