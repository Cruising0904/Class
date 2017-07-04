package dao;

import java.sql.Connection;
import java.sql.SQLException;

import Common.DBConn2;

public class InsertEX {
	Connection con;
	
	public void setConnection() throws ClassNotFoundException, SQLException {
		con = DBConn2.getCon();
	}
	
}
