package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Common.DBConn2;

public class BoardDAO {
	Connection con;

	public void setConnection() throws ClassNotFoundException, SQLException {
		con = DBConn2.getCon();
	}

	public boolean insertBoard() {
		String sql = "insert into board(title, content, writer, reg_date) values('게시판제목3','게시판내용3',2,now())";
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

	public boolean updateBoard() throws SQLException {
		String sql = "update board set title = '으하하하' where num='1'";
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
				e1.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] aregs) {
		BoardDAO bdao = new BoardDAO();
		try {
			bdao.setConnection();
			bdao.insertBoard();
			bdao.updateBoard();
			System.out.println("정상동작 했고 저장까지 완료");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("뭔진 모르겠는데 에러가 나서 원복했수다.");
			e.printStackTrace();
		}
	}
}
