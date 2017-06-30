package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Common.DBConn2;

public class TestDAO {

	public boolean insertTest(){
		try {
			Connection con = DBConn2.getCon();
			String sql = "insert into test(TITLE, CONTENT, WRITER, REG_DATE)";
					sql+= " values(?,?,?,?)"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  "게시물3");
			ps.setString(2,  "내용3");
			ps.setString(3,  "1");
			int result = ps.executeUpdate();
			if(result==1){
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Map> selectTest(){
		List<Map> testList = new ArrayList<Map>();
		try {
			Connection con = DBConn2.getCon();
			
			String sql="SELECT T.",UI.ID, UI.NAME FROM TEST AS T, USER_INFO AS UI";"
					PreparedStatement ps = con.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean updateTest(){
		return true;
	}
	public boolean deleteTest(){
		return true;
	}
	public static void main(String[]args){
//		TestDAO tdao = new TestDAO();
//		if(tdao.insertTest()){
//			System.out.println("오~ 테스트테이블에 입력이 잘되었습니다.");
//		}
//		Date d = new Date();
//		System.out.println(d.toString());
//		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdt.format(d));
	}
}
