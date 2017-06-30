package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Common.DBConn2;

public class TestDAO {

	public boolean insertTest() {
		try {
			Connection con = DBConn2.getCon();
			String sql = "insert into test(TITLE, CONTENT, WRITER, REG_DATE)";
			sql += " values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "게시물3");
			ps.setString(2, "내용3");
			ps.setString(3, "1");
			Date d = new Date();
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(4, sdt.format(d));
			int result = ps.executeUpdate();
			if (result == 1) {
				return true;
			}
			DBConn2.closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Map> selectTest() {
		List<Map> testList = new ArrayList<Map>();
		try {
			Connection con = DBConn2.getCon();

			String sql = "SELECT T.*,UI.ID, UI.NAME FROM TEST AS T, USER_INFO AS UI";
			sql += " Where t.writer = ui.num;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map hm = new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("title", rs.getString("title"));
				hm.put("content", rs.getString("content"));
				hm.put("writer", rs.getString("writer"));
				hm.put("reg_date", rs.getString("reg_date"));
				hm.put("id", rs.getString("id"));
				hm.put("name", rs.getString("name"));
				testList.add(hm);
			}
			DBConn2.closeCon();
			return testList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateTest() {
		return true;
	}

	public boolean deleteTest() {
		return true;
	}

	public static void main(String[] args) {
		 TestDAO tdao = new TestDAO();
		 if(tdao.insertTest()){
		 System.out.println("오~ 테스트테이블에 입력이 잘되었습니다.");
		 }
		 
//		 List<Map> list = to.selectTest();
//		 for(Map m : list){
//			 System.out.println(m);
		 }
		// Date d = new Date();
		// System.out.println(d.toString());
		// SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println(sdt.format(d));
//	}
}
