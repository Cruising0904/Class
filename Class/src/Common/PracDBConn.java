package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PracDBConn {

	private static Connection con;
	
	public static Connection getCon() throws SQLException, ClassNotFoundException{
		if(con == null){
			Class.forName("org.mariadb.jdbc.driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/iot_test","root","sql369123");
		}
		return con;
	}
	public static void main(String[]args){
		try{
			Connection con = DBConn2.getCon();
			System.out.println("접속!");
			DBConn2.closeCon();
			System.out.println("종료");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void closeCon() throws SQLException{
		if(con!=null){
			con.close();
			con=null;
		}
	}
}
