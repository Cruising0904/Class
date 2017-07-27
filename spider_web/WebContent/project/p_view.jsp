<%@ include file="/project/p_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
 <%@ page import="com.test.dto.BoardInfo" %>
<body>
<%
	int pBinum = Integer.parseInt(request.getParameter("binum"));
	Connection con = null;
	PreparedStatement ps = null;
	int binum = 0;
	String bititle = "";
	String bicontent = "";
	String bipwd = "";
	String creusr = "";
	String credat = "";
	try{
		con = DBConn2.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where binum=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,pBinum);
		ResultSet rs = ps.executeQuery();
		rs.last();      // 행의 마지막거를 출력하는 함수
		int rowCnt = rs.getRow();// getRow 로 받아줌.
		if(rowCnt==0){
%>
			<script>
				alert("<%=pBinum%>번 게시물은 이미 지워졌어 자시가");
				history.back();
			</script>
<%
		}
		rs.beforeFirst(); // 지워진걸 위로 넣는 로직
		while(rs.next()){
			binum = rs.getInt("binum");
			bititle = rs.getString("bititle");
			bicontent = rs.getString("bicontent");
			creusr = rs.getString("creusr");
			credat = rs.getString("credat");
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn2.closeCon();
	}
%>

번호 : <%=binum%><br/>
제목 : <%=bititle%><br/>
내용 : <%=bicontent%><br/>
글쓴이 : <%=creusr%><br/>
생성일자 :  <%=credat%><br/>
비밀번호 : <input type="password" name="bipwd" id="bipwd" /><br/>
<input type="button" value="수정" onclick="modifyBoard()"/> <input type="button" value="삭제"onclick="deleteBoard()"/>
<script>
function deleteBoard(){
	var bipwd = document.getElementById("bipwd").value;
	location.href="<%=rootPath%>/project/p_delete.jsp?binum=<%=binum%>&bipwd=" + bipwd; 
}
function modifyBoard(){
	var bipwd = document.getElementById("bipwd").value;
	location.href="<%=rootPath%>/project/p_modify.jsp?binum=<%=binum%>&bipwd=" + bipwd; 
}
</script>
</body>
</html>