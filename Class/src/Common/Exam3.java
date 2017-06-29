package Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Exam3 {
	
	public List<HashMap> doSelect(){ //제너릭 is ? // 다이아몬드 안에 아무거나 들어가도 됨.
		return null;
	}
	public List<String> getUserIDLists(String name){ // 인서트를 치환해주기
		//String result = "";
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn2.getCon();			
			String sql = "select ID,PWD,NAME,age from user";
			if(!name.equals("")){
				sql += " WHERE NAME=?";//큰따옴표 옆에 빈칸해준 이유는 위에 쿼리문다음에 붙어서 나오기 때무넹 인식을 못해서
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {		
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));
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
			String sql = "insert into user(id, pwd, name, age)values('blue','blue','청길동',40)";
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
	public boolean deleteUser(int num){
		try {
			Connection con = DBConn2.getCon();			
			String sql = "delete user where num=" + num;
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result>0){
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void main(String[] args){
		Exam3 e = new Exam3();
		if(e.insertUser()){
			System.out.println("오~ 잘들어갔네요 유저테이블에!!");
		}
		
		boolean isDel = e.deleteUser(1);
		if(isDel){
			System.out.println("유저테이블에 잘 삭제가 됬네요!");
		}
		List<String> userList = e.getUserIDLists("");
		for(int i=0;i<userList.size();i++){
			System.out.println(userList.get(i));
		}
	}
}
