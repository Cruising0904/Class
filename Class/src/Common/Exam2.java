package Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exam2 {

public static class Exam {
	public List<String> getUserIDLists(String name){
		//String result = "";
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn2.getCon();			
			String sql = "select ID,PWD,NAME,age from user";
			if(!name.equals("")){
				sql += " WHERE NAME='" + name + "'";
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {		
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));//()안에 숫자에 컬럼명 그대로 적어줘도됨
			}			
			DBConn2.closeCon();
			return userlist;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertUser(){
		try {
			Connection con = DBConn2.getCon();	
			Scanner scan = new Scanner(System.in);
			HashMap<String, String> valueHm = new HashMap<String, String>();
			valueHm.put("id", scan.nextLine());
			valueHm.put("pwd", scan.nextLine());
			valueHm.put("name", scan.nextLine());
			valueHm.put("age", scan.nextLine());
			
			String sql = "insert into user(id, pwd, name, age)values("+hm.get("id")+";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result==1){
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args){
		Exam e = new Exam();
//		e.insertUser();
		List<String> userList = e.getUserIDLists("");
		for(int i=0;i<userList.size();i++){
			System.out.println(userList.get(i));
		}
	}
}
}